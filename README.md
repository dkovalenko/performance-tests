How to run:

`make benchmark`

Results:

```
Benchmark                         Mode    Cnt      Score    Error  Units
IsDarkBenchmark.baseline            sample   1710  29266.021 ± 84.293  us/op
IsDarkBenchmark.baseline:p0.00      sample         27033.600           us/op
IsDarkBenchmark.baseline:p0.50      sample         29425.664           us/op
IsDarkBenchmark.baseline:p0.90      sample         30539.776           us/op
IsDarkBenchmark.baseline:p0.95      sample         30932.992           us/op
IsDarkBenchmark.baseline:p0.99      sample         31617.516           us/op
IsDarkBenchmark.baseline:p0.999     sample         34777.989           us/op
IsDarkBenchmark.baseline:p0.9999    sample         36175.872           us/op
IsDarkBenchmark.baseline:p1.00      sample         36175.872           us/op
IsDarkBenchmark.cachelines          sample  11454   4364.354 ± 14.102  us/op
IsDarkBenchmark.cachelines:p0.00    sample          4075.520           us/op
IsDarkBenchmark.cachelines:p0.50    sample          4276.224           us/op
IsDarkBenchmark.cachelines:p0.90    sample          4374.528           us/op
IsDarkBenchmark.cachelines:p0.95    sample          5326.848           us/op
IsDarkBenchmark.cachelines:p0.99    sample          6909.542           us/op
IsDarkBenchmark.cachelines:p0.999   sample          8039.260           us/op
IsDarkBenchmark.cachelines:p0.9999  sample         14618.952           us/op
IsDarkBenchmark.cachelines:p1.00    sample         14761.984           us/op
IsDarkBenchmark.noIf                sample   4434  11278.625 ± 28.212  us/op
IsDarkBenchmark.noIf:p0.00          sample         10878.976           us/op
IsDarkBenchmark.noIf:p0.50          sample         11108.352           us/op
IsDarkBenchmark.noIf:p0.90          sample         11575.296           us/op
IsDarkBenchmark.noIf:p0.95          sample         13025.280           us/op
IsDarkBenchmark.noIf:p0.99          sample         13352.960           us/op
IsDarkBenchmark.noIf:p0.999         sample         13800.980           us/op
IsDarkBenchmark.noIf:p0.9999        sample         16580.608           us/op
IsDarkBenchmark.noIf:p1.00          sample         16580.608           us/op
```