# Changelog

## 0.1.0-alpha.1 (2025-05-19)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/dinaricrypto/dinari-api-sdk-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### ⚠ BREAKING CHANGES

* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** api update ([d366886](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/d3668867f31fd35eab551339ca7afdd20621f5d7))
* **api:** api update ([a3e4075](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/a3e4075810cbf01ac57134498bd4d2ca56f5b6df))
* **api:** api update ([9ef95d9](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/9ef95d9afd335e8dead490140083dae39853502a))
* **api:** manual updates ([0726eb1](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/0726eb152d73470e1fc5a2db80edbe057b3956a8))
* **client:** allow providing some params positionally ([b0fd487](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/b0fd487d016d3e6d68e0e41c422dca2dc07f53ae))
* **client:** extract auto pagination to shared classes ([43c51a3](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/43c51a30da0ca7ae74fefe328d7edfe2d2538a22))


### Chores

* configure new SDK language ([cbea091](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/cbea0912c4d4c536a7de1732adc0e93710cb76b5))
* go live ([e4f899e](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/e4f899e562a71cc0847c08d8e451d7c6556168cf))
* **internal:** remove flaky `-Xbackend-threads=0` option ([707da36](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/707da36ca595b67f8bd21ad9c86a783c848c51ac))
* **internal:** update java toolchain ([b8961be](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/b8961bec1738c9ea36576cf1e027573f9a376354))
