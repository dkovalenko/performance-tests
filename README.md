**How to run:**

`make benchmark`

**Results:**


*Sample time*
```
Benchmark                             Mode   Cnt   Score   Error  Units
IsDarkBenchmark.baseline            sample  2110  23.733 ± 0.120  ms/op
IsDarkBenchmark.baseline:p0.00      sample        21.791          ms/op
IsDarkBenchmark.baseline:p0.50      sample        23.200          ms/op
IsDarkBenchmark.baseline:p0.90      sample        25.625          ms/op
IsDarkBenchmark.baseline:p0.95      sample        26.411          ms/op
IsDarkBenchmark.baseline:p0.99      sample        28.727          ms/op
IsDarkBenchmark.baseline:p0.999     sample        42.621          ms/op
IsDarkBenchmark.baseline:p0.9999    sample        50.332          ms/op
IsDarkBenchmark.baseline:p1.00      sample        50.332          ms/op
IsDarkBenchmark.cachelines          sample  9264   5.397 ± 0.007  ms/op
IsDarkBenchmark.cachelines:p0.00    sample         5.095          ms/op
IsDarkBenchmark.cachelines:p0.50    sample         5.333          ms/op
IsDarkBenchmark.cachelines:p0.90    sample         5.652          ms/op
IsDarkBenchmark.cachelines:p0.95    sample         5.825          ms/op
IsDarkBenchmark.cachelines:p0.99    sample         6.218          ms/op
IsDarkBenchmark.cachelines:p0.999   sample         7.097          ms/op
IsDarkBenchmark.cachelines:p0.9999  sample         7.791          ms/op
IsDarkBenchmark.cachelines:p1.00    sample         7.791          ms/op
IsDarkBenchmark.noIf                sample  4482  11.160 ± 0.016  ms/op
IsDarkBenchmark.noIf:p0.00          sample        10.945          ms/op
IsDarkBenchmark.noIf:p0.50          sample        11.059          ms/op
IsDarkBenchmark.noIf:p0.90          sample        11.567          ms/op
IsDarkBenchmark.noIf:p0.95          sample        12.026          ms/op
IsDarkBenchmark.noIf:p0.99          sample        12.176          ms/op
IsDarkBenchmark.noIf:p0.999         sample        13.468          ms/op
IsDarkBenchmark.noIf:p0.9999        sample        13.550          ms/op
IsDarkBenchmark.noIf:p1.00          sample        13.550          ms/op
```

*Throughput*
```
Benchmark                    Mode  Cnt    Score   Error  Units
IsDarkBenchmark.baseline    thrpt    5   36.096 ± 0.622  ops/s
IsDarkBenchmark.cachelines  thrpt    5  232.854 ± 2.151  ops/s
IsDarkBenchmark.noIf        thrpt    5   88.790 ± 0.491  ops/s
```