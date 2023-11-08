**How to run:**

`make benchmark`

**Results:**


*Sample time*
```
Benchmark                             Mode  Cnt     Score    Error  Units
IsDarkBenchmark.baseline            sample   15  3409.969 ± 23.484  ms/op
IsDarkBenchmark.baseline:p0.00      sample       3388.998           ms/op
IsDarkBenchmark.baseline:p0.50      sample       3405.775           ms/op
IsDarkBenchmark.baseline:p0.90      sample       3449.396           ms/op
IsDarkBenchmark.baseline:p0.95      sample       3477.078           ms/op
IsDarkBenchmark.baseline:p0.99      sample       3477.078           ms/op
IsDarkBenchmark.baseline:p0.999     sample       3477.078           ms/op
IsDarkBenchmark.baseline:p0.9999    sample       3477.078           ms/op
IsDarkBenchmark.baseline:p1.00      sample       3477.078           ms/op
IsDarkBenchmark.cachelines          sample  243   207.795 ±  0.509  ms/op
IsDarkBenchmark.cachelines:p0.00    sample        205.259           ms/op
IsDarkBenchmark.cachelines:p0.50    sample        206.832           ms/op
IsDarkBenchmark.cachelines:p0.90    sample        212.232           ms/op
IsDarkBenchmark.cachelines:p0.95    sample        213.071           ms/op
IsDarkBenchmark.cachelines:p0.99    sample        214.843           ms/op
IsDarkBenchmark.cachelines:p0.999   sample        215.482           ms/op
IsDarkBenchmark.cachelines:p0.9999  sample        215.482           ms/op
IsDarkBenchmark.cachelines:p1.00    sample        215.482           ms/op
IsDarkBenchmark.noIf                sample  732    68.484 ±  0.147  ms/op
IsDarkBenchmark.noIf:p0.00          sample         67.043           ms/op
IsDarkBenchmark.noIf:p0.50          sample         68.420           ms/op
IsDarkBenchmark.noIf:p0.90          sample         69.337           ms/op
IsDarkBenchmark.noIf:p0.95          sample         70.386           ms/op
IsDarkBenchmark.noIf:p0.99          sample         72.876           ms/op
IsDarkBenchmark.noIf:p0.999         sample         83.493           ms/op
IsDarkBenchmark.noIf:p0.9999        sample         83.493           ms/op
IsDarkBenchmark.noIf:p1.00          sample         83.493           ms/op
```

*Throughput*
```
Benchmark                    Mode  Cnt   Score   Error  Units
IsDarkBenchmark.baseline    thrpt    5   0.292 ± 0.017  ops/s
IsDarkBenchmark.cachelines  thrpt    5   4.769 ± 0.089  ops/s
IsDarkBenchmark.noIf        thrpt    5  14.786 ± 0.126  ops/s
```