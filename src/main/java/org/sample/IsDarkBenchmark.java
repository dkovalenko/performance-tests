/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sample;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class IsDarkBenchmark {

    static Random rnd = new Random();

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        static int N = 4096;
        static volatile short[][] image = new short[N][N];

        @Setup(Level.Trial)
        public void doSetup() {
            fillImage();
            System.out.println("Do Setup");
        }
        
        public static void fillImage() {
            try {
                FileWriter fileWriter = new FileWriter("image_sample.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        short rndValue = (short) rnd.nextInt(Short.MAX_VALUE + 1);
                        image[i][j] = rndValue;
                        bufferedWriter.write(rndValue + " ");
                    }
                    bufferedWriter.write("\n");
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void baseline(Blackhole bh, BenchmarkState state) {
        boolean isDark = isDarkBaseline(state.N, state.image);
        bh.consume(isDark);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void cachelines(Blackhole bh, BenchmarkState state) {
        boolean isDark = isDarkCachelines(state.N, state.image);
        bh.consume(isDark);
    }

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void noIf(Blackhole bh, BenchmarkState state) {
        int N = 4096;
        short[][] image = new short[N][N];
        boolean isDark = isDarkNoIf(N, state.image);
        bh.consume(isDark);
    }

    boolean isDarkBaseline(int N, short[][] image) {
        int count = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (image[i][j] >= 128) {
                    count += 1;
                }
            }
        }
        return count < N * N / 2;
    }

    boolean isDarkCachelines(int N, short[][] image) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (image[i][j] >= 128) {
                    count += 1;
                }
            }
        }
        return count < N * N / 2;
    }

    boolean isDarkNoIf(int N, short[][] image) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += (byte) image[i][j] >> 7;
            }
        }
        return count < N * N / 2;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IsDarkBenchmark.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
