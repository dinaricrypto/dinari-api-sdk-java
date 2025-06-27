# Changelog

## 0.3.0 (2025-06-27)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/dinaricrypto/dinari-api-sdk-java/compare/v0.2.0...v0.3.0)

### Features

* **api:** api update ([0d6cf10](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/0d6cf1083a416d0448430f5626c333338c7c311b))
* **api:** api update ([5dfab8d](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/5dfab8d20d5031418af280e1f9316ce1924dd806))
* **api:** api update ([e70ed39](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/e70ed39a9535f50ffe7deb507cc07e8f07a814ed))
* **api:** api update ([ab8b494](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/ab8b4947b91bffd9fe6648a19c76efe1996acc40))
* **api:** remove quote api ([9d28d49](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/9d28d4992fa6730a95a05ab583d4159a0e794770))


### Bug Fixes

* **ci:** release-doctor — report correct token name ([b8b59ff](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/b8b59ff72dcef143f7174a47e0e08febfbd7a6f4))

## 0.2.0 (2025-06-24)

Full Changelog: [v0.1.1...v0.2.0](https://github.com/dinaricrypto/dinari-api-sdk-java/compare/v0.1.1...v0.2.0)

### Features

* **api:** 20250624 new updates ([f2c222b](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/f2c222b68af91d47a8b4b5c9e0ff0bd57f6d8705))
* **api:** api update ([2edc8e4](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/2edc8e42c21e10c0c3e185a0b2b339aa74926200))
* **api:** api update ([ae8a1f3](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/ae8a1f38ada852b5aff3655857670b7366aaeae7))


### Bug Fixes

* **client:** bump max requests per host to max requests (5 -&gt; 64) ([e4e9ef7](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/e4e9ef7d8cafabf2b602588b19b62df30b863ab4))

## 0.1.1 (2025-06-22)

Full Changelog: [v0.1.0...v0.1.1](https://github.com/dinaricrypto/dinari-api-sdk-java/compare/v0.1.0...v0.1.1)

### Features

* **api:** Add link to docs ([81495ec](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/81495ecfe33e1248f0039d6ff44468023b111d31))
* **api:** api update ([2f2f324](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/2f2f32483c2969f97073bf89ca1ed3605bf78891))

## 0.1.0 (2025-06-22)

Full Changelog: [v0.0.1-alpha.0...v0.1.0](https://github.com/dinaricrypto/dinari-api-sdk-java/compare/v0.0.1-alpha.0...v0.1.0)

### ⚠ BREAKING CHANGES

* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** api update ([c913f16](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/c913f1663e3bd5966cbc6de82b4a1d36a095542f))
* **api:** api update ([48359be](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/48359bee69162a56480052964c69a15bb117871d))
* **api:** api update ([d366886](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/d3668867f31fd35eab551339ca7afdd20621f5d7))
* **api:** api update ([a3e4075](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/a3e4075810cbf01ac57134498bd4d2ca56f5b6df))
* **api:** api update ([9ef95d9](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/9ef95d9afd335e8dead490140083dae39853502a))
* **api:** generated missing apis ([2b73f05](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/2b73f0528b48bf26f1dfd3d2dbedd00c9916873d))
* **api:** manual updates ([c903d52](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/c903d5281eb7fc49476dc8acad1d447e7a36e424))
* **api:** manual updates ([c759733](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/c7597332e2eab1f953f813c1d1eeb8bccf626663))
* **api:** manual updates ([0726eb1](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/0726eb152d73470e1fc5a2db80edbe057b3956a8))
* **api:** reverting Java reverse domain ([76d4c76](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/76d4c76c0c70513f9c4aa2a53b0e271c86d9fe90))
* **api:** Update Java target to use Central Portal ([d11a944](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/d11a94420612993071d9ab662a154a607e4cc78b))
* **api:** update routes ([79e00cd](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/79e00cd2f20ee05b3330ba8373797253edb25d41))
* **client:** add a `withOptions` method ([cf4fd33](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/cf4fd33bf728b2d53418fde162ae8ba258d0e153))
* **client:** allow providing some params positionally ([b0fd487](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/b0fd487d016d3e6d68e0e41c422dca2dc07f53ae))
* **client:** extract auto pagination to shared classes ([43c51a3](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/43c51a30da0ca7ae74fefe328d7edfe2d2538a22))
* **client:** implement per-endpoint base URL support ([48c7e89](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/48c7e89178082b83355c3693d6973c46970bc3a7))


### Bug Fixes

* **client:** remove `@MustBeClosed` for future returning methods ([90fbed8](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/90fbed807b40e4e3a1056d988b17b5e4129a1883))
* **tests:** bad asserts ([1325d21](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/1325d2198a4c5b79486f03092a7caf42dcb13c2a))
* **tests:** skip improperly generated tests ([6bc2ee3](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/6bc2ee344bacbdcf7f66c29284372f9b7a81f7e2))


### Chores

* **ci:** enable for pull requests ([64092ea](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/64092ea4f404f275a1e78e7aae21e0db1110be8b))
* configure new SDK language ([cbea091](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/cbea0912c4d4c536a7de1732adc0e93710cb76b5))
* **docs:** grammar improvements ([c9f2964](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/c9f29649c746b8ef365fd4c87a8d85380a009e78))
* go live ([e4f899e](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/e4f899e562a71cc0847c08d8e451d7c6556168cf))
* **internal:** codegen related update ([cc3e441](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/cc3e441ddf20918032297b85e80d205442569e0a))
* **internal:** remove flaky `-Xbackend-threads=0` option ([707da36](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/707da36ca595b67f8bd21ad9c86a783c848c51ac))
* **internal:** update java toolchain ([b8961be](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/b8961bec1738c9ea36576cf1e027573f9a376354))
* update SDK settings ([523d374](https://github.com/dinaricrypto/dinari-api-sdk-java/commit/523d374cad31b4cbe41b993718d587cef64c3f43))
