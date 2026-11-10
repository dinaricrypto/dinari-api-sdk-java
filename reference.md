# Reference
## Market Data
<details><summary><code>client.marketData.getAlloys() -> PaginatedAlloyResponseV1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Returns available `Alloys` with cursor-based pagination.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getAlloys(
    GetAlloysRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**symbols:** `Optional<String>` — If set, this endpoint will return Alloys that match the symbols specified
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAlloysRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getAlloyCurrentPrice(alloyId) -> AlloyPriceV1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the current price for a specified `Alloy`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getAlloyCurrentPrice(
    GetAlloyCurrentPriceRequest
        .builder()
        .alloyId("alloy_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**alloyId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getAlloyPriceChart(alloyId) -> List&amp;lt;AlloyHistoricalPriceDataPointV1&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get historical price data for a specified `Alloy`. Each index in the array represents a single tick in a price chart.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getAlloyPriceChart(
    GetAlloyPriceChartRequest
        .builder()
        .alloyId("alloy_id")
        .timespan(GetAlloyPriceChartRequestTimespan.DAY)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**alloyId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**timespan:** `GetAlloyPriceChartRequestTimespan` — The timespan of the historical prices to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getStocks() -> GetStocksResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of `Stocks`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getStocks(
    GetStocksRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**symbols:** `Optional<String>` — List of `Stock` symbols to query. If not provided, all `Stocks` are returned.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetStocksRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getStockCurrentPrice(stockId) -> StockPrice</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get current price for a specified `Stock`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getStockCurrentPrice(
    GetStockCurrentPriceRequest
        .builder()
        .stockId("stock_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getStockCurrentQuotesRouteV2(stockId) -> StockQuoteResponseOneOfSchema</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get quote for a specified `Stock`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getStockCurrentQuotesRouteV2(
    GetStockCurrentQuotesRouteV2Request
        .builder()
        .stockId("stock_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**feed:** `Optional<MarketDataFeed>` 

Requested data source for the quote. Only applies when using x-api-version: 2.
Allowed values:

- `null`: (default) Selects the highest quality available free data source.
- `sip`: Consolidated quote from all U.S. exchanges (NBBO). This is a paid data source and incurs usage-based billing.
    
</dd>
</dl>

<dl>
<dd>

**entityId:** `Optional<String>` — Entity id of customer requesting quote. Required to use sip feed. If this is an internal query, supply your organization entity_id
    
</dd>
</dl>

<dl>
<dd>

**apiVersion:** `Optional<String>` — Version for this method
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getStockPriceChart(stockId) -> List&amp;lt;StocksHistoricalPriceDataPoint&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get historical price data for a specified `Stock`. Each index in the array represents a single tick in a price chart.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getStockPriceChart(
    GetStockPriceChartRequest
        .builder()
        .stockId("stock_id")
        .timespan(StockTickTimespan1.DAY)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**timespan:** `StockTickTimespan1` — The timespan of the historical prices to query.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getStockNewsByStockId(stockId) -> List&amp;lt;StockNewsArticleInfo&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the most recent news articles relating to a `Stock`, including a summary of the article 
        and a link to the original source.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getStockNewsByStockId(
    GetStockNewsByStockIdRequest
        .builder()
        .stockId("stock_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — The number of articles to return.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.marketData.getMarketHours() -> ExtendedMarketHours</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the market hours for the current trading session and next open trading session.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.marketData().getMarketHours();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Corporate Actions
<details><summary><code>client.corporateActions.getStockSplits() -> GetStockSplitsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get a list of stock splits for `Stocks` available for trade via Dinari.
The splits are ordered by the date they were created, with the most recent split first.

In an example 10-for-1 stock split, trading will be halted for the stock at the end of the `payable_date`, as
the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs over a weekend to minimize trading
disruptions. Each share of stock owned by a shareholder will then be converted into 10 shares, and the split
becomes `COMPLETE` as trading resumes on the `ex_date` with new split-adjusted prices.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.corporateActions().getStockSplits(
    GetStockSplitsRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetStockSplitsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.corporateActions.getStockSplitsById(stockId) -> GetStockSplitsByIdResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get a list of stock splits for a specific `Stock`.
The splits are ordered by the date they were created, with the most recent split first.

In an example 10-for-1 stock split, trading will be halted for the stock at the end of the `payable_date`, as
the split transitions from `PENDING` to `IN_PROGRESS`. This usually occurs over a weekend to minimize trading
disruptions. Each share of stock owned by a shareholder will then be converted into 10 shares, and the split
becomes `COMPLETE` as trading resumes on the `ex_date` with new split-adjusted prices.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.corporateActions().getStockSplitsById(
    GetStockSplitsByIdRequest
        .builder()
        .stockId("stock_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetStockSplitsByIdRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.corporateActions.getStockDividendsByStockId(stockId) -> List&amp;lt;StockDividendAnnouncementDetail&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get a list of announced stock dividend details for a specified `Stock`.

Note that this data applies only to actual stocks. Yield received for holding tokenized shares may differ from this.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.corporateActions().getStockDividendsByStockId(
    GetStockDividendsByStockIdRequest
        .builder()
        .stockId("stock_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**stockId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Entities
<details><summary><code>client.entities.getEntities() -> GetEntitiesResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of direct `Entities` your organization manages. These `Entities` represent individual customers of your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.entities().getEntities(
    GetEntitiesRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**referenceId:** `Optional<String>` — Case sensitive unique reference ID for the `Entity`.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetEntitiesRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.entities.createEntities(request) -> Entity1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new `Entity` to be managed by your organization. This `Entity` represents an individual customer of your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.entities().createEntities(
    CreateEntityInput
        .builder()
        .name("name")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**name:** `String` — Name of the `Entity`.
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` — Case sensitive unique reference ID for the `Entity`. We recommend setting this to the unique ID of the `Entity` in your system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.entities.getCurrentEntity() -> Entity1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the current authenticated `Entity`, which represents your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.entities().getCurrentEntity();
```
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.entities.getEntityById(entityId) -> Entity1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific customer `Entity` of your organization by their ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.entities().getEntityById(
    GetEntityByIdRequest
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.entities.updateEntityById(entityId, request) -> Entity1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Update a specific customer `Entity` of your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.entities().updateEntityById(
    PatchEntityInput
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**referenceId:** `Optional<String>` — Case sensitive unique reference ID for the `Entity`. We recommend setting this to the unique ID of the `Entity` in your system.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Accounts
<details><summary><code>client.accounts.getEntityAccounts(entityId) -> GetEntityAccountsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of all `Accounts` that belong to a specific `Entity`. This `Entity` represents your organization itself, or an individual customer of your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getEntityAccounts(
    GetEntityAccountsRequest
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetEntityAccountsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.createEntityAccounts(entityId, request) -> Account1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Create a new `Account` for a specific `Entity`. This `Entity` represents your organization itself, or an individual customer of your organization.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().createEntityAccounts(
    CreateAccountInput
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**jurisdiction:** `Optional<Jurisdiction>` — Jurisdiction of the `Account`.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getAccount(accountId) -> Account1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `Account` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getAccount(
    GetAccountRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.createAccountDeactivation(accountId) -> Account1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Set the `Account` to be inactive. Inactive accounts cannot be used for trading.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().createAccountDeactivation(
    CreateAccountDeactivationRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getAccountPortfolio(accountId) -> Portfolio</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getAccountPortfolio(
    GetAccountPortfolioRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` — The page number.
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The number of stocks to return per page, maximum number is 200.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getAccountCash(accountId) -> List&amp;lt;PaymentTokenBalance&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the cash balances of the `Account`, including stablecoins and other cash equivalents.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getAccountCash(
    GetAccountCashRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getAccountInterestPayments(accountId) -> GetAccountInterestPaymentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get interest payments made to the `Account` from yield-bearing cash holdings.

Currently, the only yield-bearing stablecoin accepted by Dinari is [USD+](https://usd.dinari.com/).
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getAccountInterestPayments(
    GetAccountInterestPaymentsRequest
        .builder()
        .accountId("account_id")
        .startDate("2023-01-15")
        .endDate("2023-01-15")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `String` — Start date, inclusive, in US Eastern time zone. ISO 8601 format, YYYY-MM-DD.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `String` — End date, exclusive, in US Eastern time zone. ISO 8601 format, YYYY-MM-DD.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountInterestPaymentsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getAccountDividendPayments(accountId) -> GetAccountDividendPaymentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get dividend payments made to the `Account` from dividend-bearing stock holdings.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getAccountDividendPayments(
    GetAccountDividendPaymentsRequest
        .builder()
        .accountId("account_id")
        .startDate("2023-01-15")
        .endDate("2023-01-15")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**startDate:** `String` — Start date, inclusive, in US Eastern time zone. ISO 8601 format, YYYY-MM-DD.
    
</dd>
</dl>

<dl>
<dd>

**endDate:** `String` — End date, exclusive, in US Eastern time zone. ISO 8601 format, YYYY-MM-DD.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — Optional ID of the `Stock` to filter by
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountDividendPaymentsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.createAccountFaucet(accountId, request)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Mints 1,000 mockUSD sandbox payment tokens to the `Wallet` connected to the `Account`.

This feature is only supported in sandbox mode.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().createAccountFaucet(
    FaucetInput
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `Optional<ChainId>` — CAIP-2 chain ID of blockchain in which to mint the sandbox payment tokens. If none specified, defaults to eip155:421614. If the `Account` is linked to a Dinari-managed `Wallet`, only eip155:42161 is allowed.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getBrokerageAccountActivities(accountId)</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get a list of brokerage activities tied to the specified `Account`.

**⚠️ ALPHA: This endpoint is in early development and subject to breaking changes.**
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getBrokerageAccountActivities(
    GetBrokerageAccountActivitiesRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` — The maximum number of entries to return in the response. Defaults to 100.
    
</dd>
</dl>

<dl>
<dd>

**pageToken:** `Optional<String>` — Pagination token. Set to the `id` field of the last Activity returned in the previous page to get the next page of results.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getTokenTransfers(accountId) -> GetTokenTransfersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get `TokenTransfer`s made from this `Account`.

A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one `Account` to another.
As such, only `Account`s that are connected to Dinari-managed `Wallet`s can initiate `TokenTransfer`s.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getTokenTransfers(
    GetTokenTransfersRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetTokenTransfersRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.createTokenTransfers(accountId, request) -> TokenTransfer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Creates a `TokenTransfer` from this `Account`.

A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one `Account` to another.
As such, only `Account`s that are connected to Dinari-managed `Wallet`s can initiate `TokenTransfer`s.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().createTokenTransfers(
    CreateManagedTokenTransferInput
        .builder()
        .accountId("account_id")
        .recipientAccountId("recipient_account_id")
        .tokenAddress("token_address")
        .quantity(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `String` — ID of the recipient account to which the tokens will be transferred.
    
</dd>
</dl>

<dl>
<dd>

**tokenAddress:** `String` — Address of the token to transfer.
    
</dd>
</dl>

<dl>
<dd>

**quantity:** `Double` — Quantity of the token to transfer.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.accounts.getTokenTransfer(accountId, transferId) -> TokenTransfer</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get a specific `TokenTransfer` made from this `Account` by its ID.

A `TokenTransfer` represents a transfer of tokens through the Dinari platform from one `Account` to another.
As such, only `Account`s that are connected to Dinari-managed `Wallet`s can initiate `TokenTransfer`s.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.accounts().getTokenTransfer(
    GetTokenTransferRequest
        .builder()
        .accountId("account_id")
        .transferId("transfer_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**transferId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## KYC
<details><summary><code>client.kyc.getEntityKyc(entityId) -> Kyc</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Get most recent KYC data of the `Entity`.

If there are any completed KYC checks, data from the most recent one will be returned.
If there are no completed KYC checks, the most recent KYC check information, regardless of status, will be returned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.kyc().getEntityKyc(
    GetEntityKycRequest
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.kyc.createEntityKyc(entityId, request) -> Kyc</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Submit KYC data directly, for partners that are provisioned to provide their own KYC data.

This feature is available for everyone in sandbox mode, and for specifically provisioned partners in production.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.kyc().createEntityKyc(
    CreateEntityKycRequest
        .builder()
        .entityId("entity_id")
        .body(
            CreateKycInput.baseline(
                CreateBaselineKycInput
                    .builder()
                    .data(
                        BaselineKycCheckDataV0
                            .builder()
                            .countryCode("SG")
                            .lastName("Doe")
                            .addressCountryCode("SG")
                            .build()
                    )
                    .providerName("provider_name")
                    .build()
            )
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `CreateKycInput` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.kyc.getEntityKycDocument(entityId, kycId) -> List&amp;lt;KycDocument&amp;gt;</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get uploaded documents for a KYC check
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.kyc().getEntityKycDocument(
    GetEntityKycDocumentRequest
        .builder()
        .entityId("entity_id")
        .kycId("kyc_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**kycId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.kyc.createEntityKycDocument(entityId, kycId, request) -> KycDocument</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Upload KYC-related documentation for partners that are provisioned to provide their own KYC data.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.kyc().createEntityKycDocument(
    new File("path/to/file"),
    CreateKycDocumentFileInput
        .builder()
        .entityId("entity_id")
        .kycId("kyc_id")
        .documentType(KycDocumentType.GOVERNMENT_ID)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**kycId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**documentType:** `KycDocumentType` — Type of `KYCDocument` to be uploaded.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.kyc.createManagedEntityKycEmbed(entityId, request) -> ManagedKycEmbed</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Create a Dinari-managed KYC Check and get a URL for your end customer to interact with.

The URL points to a web-based KYC interface that can be presented to the end customer for KYC verification.
Once the customer completes this KYC flow, the KYC check will be created and available in the KYC API.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.kyc().createManagedEntityKycEmbed(
    CreateManagedKycInput
        .builder()
        .entityId("entity_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**entityId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**jurisdiction:** `Optional<Jurisdiction>` — Jurisdiction for the KYC check. Defaults to BASELINE.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Orders
<details><summary><code>client.orders.getEntityOrders() -> GetEntityOrdersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of all `Orders` under the `Entity`.<br>Optionally `Orders` can be transaction hash or fulfillment transaction hash.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getEntityOrders(
    GetEntityOrdersRequest
        .builder()
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**chainId:** `Optional<String>` — CAIP-2 formatted chain ID of the blockchain the `Order` was made on.
    
</dd>
</dl>

<dl>
<dd>

**orderTransactionHash:** `Optional<String>` — Transaction hash of the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**orderFulfillmentTransactionHash:** `Optional<String>` — Fulfillment transaction hash of the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**orderRequestId:** `Optional<String>` — Order Request ID for the `Order`
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetEntityOrdersRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getOrders(accountId) -> GetOrdersResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of all `Orders` under the `Account`.<br>Optionally `Orders` can be filtered by chain ID, transaction hash, or client order ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getOrders(
    GetOrdersRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `Optional<String>` — CAIP-2 formatted chain ID of the blockchain the `Order` was made on.
    
</dd>
</dl>

<dl>
<dd>

**orderTransactionHash:** `Optional<String>` — Transaction hash of the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied identifier to search for `Order`s.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetOrdersRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getOrderById(accountId, orderId) -> Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `Order` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getOrderById(
    GetOrderByIdRequest
        .builder()
        .accountId("account_id")
        .orderId("order_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.createOrderCancellation(accountId, orderId) -> Order</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Cancel an `Order` by its ID. Note that this requires the `Order` ID, not the `OrderRequest` ID.
Once you submit a cancellation request, it cannot be undone. Be advised that orders with a
status of PENDING_FILL, PENDING_ESCROW, FILLED, REJECTED, or CANCELLED cannot be cancelled.

`Order` cancellation is not guaranteed nor is it immediate. The `Order` may still be executed
if the cancellation request is not received in time.

Check the status using the "Get Order by ID" endpoint to confirm whether the `Order` has been cancelled.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().createOrderCancellation(
    CreateOrderCancellationRequest
        .builder()
        .accountId("account_id")
        .orderId("order_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.createBatchOrderCancellation(accountId, request) -> BatchCancelOrderResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Cancel multiple `Orders` by their IDs in a single request. Note that this requires the `Order` IDs, not the `OrderRequest` IDs.
Once you submit a cancellation request, it cannot be undone. Be advised that orders with a
status of PENDING_FILL, PENDING_ESCROW, FILLED, REJECTED, or CANCELLED cannot be cancelled.

`Order` cancellation is not guaranteed nor is it immediate. The `Orders` may still be executed
if the cancellation request is not received in time.

The response will indicate which orders were successfully queued to cancel and which failed to queue.
Check the status using the "Get Order by ID" endpoint to confirm whether individual `Orders` have been cancelled.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().createBatchOrderCancellation(
    BatchCancelOrderInput
        .builder()
        .accountId("account_id")
        .orderIds(
            Arrays.asList("order_ids")
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderIds:** `List<String>` — List of `Order` IDs to cancel
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getAccountAllOrderFulfillments(accountId) -> GetAccountAllOrderFulfillmentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Query `OrderFulfillments` under the `Account`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getAccountAllOrderFulfillments(
    GetAccountAllOrderFulfillmentsRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderIds:** `Optional<String>` — List of `Order` IDs to query `AccountOrderFulfillment` for.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountAllOrderFulfillmentsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getAccountOrderFulfillments(accountId, orderId) -> GetAccountOrderFulfillmentsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get `OrderFulfillments` for a specific `Order`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getAccountOrderFulfillments(
    GetAccountOrderFulfillmentsRequest
        .builder()
        .accountId("account_id")
        .orderId("order_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountOrderFulfillmentsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orders.getAccountOrderFulfillmentById(accountId, orderFulfillmentId) -> OrderFulfillment</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `OrderFulfillment` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orders().getAccountOrderFulfillmentById(
    GetAccountOrderFulfillmentByIdRequest
        .builder()
        .accountId("account_id")
        .orderFulfillmentId("order_fulfillment_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderFulfillmentId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Wallets
<details><summary><code>client.wallets.getWallet(accountId) -> Wallet</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get the wallet connected to the `Account`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.wallets().getWallet(
    GetWalletRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.wallets.getAccountWalletConnectionNonce(accountId) -> AccountWalletConnectionMessage</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a nonce and message to be signed in order to verify `Wallet` ownership.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.wallets().getAccountWalletConnectionNonce(
    GetAccountWalletConnectionNonceRequest
        .builder()
        .accountId("account_id")
        .walletAddress("wallet_address")
        .chainId(WalletChainId.EIP1550)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**walletAddress:** `String` — Address of the `Wallet` to connect.
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `WalletChainId` — CAIP-2 formatted chain ID of the blockchain the `Wallet` is on. eip155:0 is used for EOA wallets
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.wallets.createAccountWalletConnection(accountId, request) -> Wallet</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Connect a `Wallet` to the `Account` after verifying the signature.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.wallets().createAccountWalletConnection(
    CreateAccountWalletConnectionInput
        .builder()
        .accountId("account_id")
        .signature("signature")
        .nonce("nonce")
        .walletAddress("wallet_address")
        .chainId(WalletChainId.EIP1550)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**signature:** `String` — Signature payload from signing the connection message with the `Wallet`.
    
</dd>
</dl>

<dl>
<dd>

**nonce:** `String` — Nonce contained within the connection message.
    
</dd>
</dl>

<dl>
<dd>

**walletAddress:** `String` — Address of the `Wallet`.
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `WalletChainId` — CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used for EOA wallets
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.wallets.createAccountWalletInternalConnection(accountId, request) -> Wallet</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Connect an internal `Wallet` to the `Account`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.wallets().createAccountWalletInternalConnection(
    CreateAccountWalletInternalConnectionInput
        .builder()
        .accountId("account_id")
        .walletAddress("wallet_address")
        .chainId(WalletChainId.EIP1550)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**walletAddress:** `String` — Address of the `Wallet`.
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `WalletChainId` — CAIP-2 formatted chain ID of the blockchain the `Wallet` to link is on. eip155:0 is used for EOA wallets
    
</dd>
</dl>

<dl>
<dd>

**isShared:** `Optional<Boolean>` — Is the linked Wallet shared or not
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Order Requests
<details><summary><code>client.orderRequests.getListOrderRequests(accountId) -> GetListOrderRequestsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Lists `OrderRequests`.<br>Optionally `OrderRequests` can be filtered by certain parameters.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orderRequests().getListOrderRequests(
    GetListOrderRequestsRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderRequestId:** `Optional<String>` — Order Request ID for the `OrderRequest`
    
</dd>
</dl>

<dl>
<dd>

**orderId:** `Optional<String>` — Order ID for the `OrderRequest`
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied ID to map this `OrderRequest` to an order in their own systems.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetListOrderRequestsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orderRequests.getOrderRequestById(accountId, orderRequestId) -> OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `OrderRequest` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orderRequests().getOrderRequestById(
    GetOrderRequestByIdRequest
        .builder()
        .accountId("account_id")
        .orderRequestId("order_request_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**orderRequestId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orderRequests.createEip155OrderRequestPermit(accountId, request) -> Eip155OrderRequestPermit</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Generates a permit that can be signed and used to create an `OrderRequest` using Dinari's EVM smart contracts.

This is a convenience method to prepare the transactions needed to create an `OrderRequest` using Dinari's EVM smart contracts.
Once signed, the transactions can be sent to the EVM network to create the order.
Note that the fee quote is already included in the transactions, so no additional fee quote lookup is needed.

Fees for the `Order` can optionally be specified in the `OrderRequest` for DFN orders in USD, supporting up to 6 decimal places.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orderRequests().createEip155OrderRequestPermit(
    Eip155OrderRequestPermitInput
        .builder()
        .accountId("account_id")
        .chainId(ChainId.EIP1551)
        .orderTif(OrderTif.DAY)
        .orderSide(OrderSide.BUY)
        .orderType(OrderType.MARKET)
        .paymentToken("payment_token")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**chainId:** `ChainId` — CAIP-2 chain ID of the blockchain where the `Order` will be placed.
    
</dd>
</dl>

<dl>
<dd>

**orderTif:** `OrderTif` — Time in force. Indicates how long `Order` is valid for.
    
</dd>
</dl>

<dl>
<dd>

**orderSide:** `OrderSide` — Indicates whether `Order` is a buy or sell.
    
</dd>
</dl>

<dl>
<dd>

**orderType:** `OrderType` — Type of `Order`.
    
</dd>
</dl>

<dl>
<dd>

**paymentToken:** `String` — Address of payment token. Required for Accounts outside of US jurisdiction. Accounts with US jurisdiction must use: USDC for live, MockUSD for sandbox.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenQuantity:** `Optional<Double>` — Amount of payment tokens involved. Required for market buy `Orders`.
    
</dd>
</dl>

<dl>
<dd>

**assetTokenQuantity:** `Optional<Double>` — Amount of dShare asset tokens involved. Required for limit `Order Requests` and market sell `Order Requests`. Must be a positive number with a precision of up to 4 decimal places for limit `Order Requests` or up to 6 decimal places for market sell `Order Requests`.
    
</dd>
</dl>

<dl>
<dd>

**limitPrice:** `Optional<Double>` — Price per asset in the asset's native currency. USD for US equities and ETFs. Required for limit `Orders`.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — The ID of the `Stock` for which the `Order` is being placed.
    
</dd>
</dl>

<dl>
<dd>

**tokenId:** `Optional<String>` — The ID of the `Token` for which the `Order` is being placed.
    
</dd>
</dl>

<dl>
<dd>

**alloyId:** `Optional<String>` — The ID of the `Alloy` for which the `Order` is being placed.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied unique identifier to map this `Order` to an order in the customer's systems.
    
</dd>
</dl>

<dl>
<dd>

**fee:** `Optional<Double>` — Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orderRequests.createEip155OrderRequestPermitTransaction(accountId, request) -> Eip155OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Submits a transaction for an EIP155 Order Request given the EIP155OrderRequest ID and Permit Signature.

An `EIP155OrderRequest` representing the proxied order is returned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orderRequests().createEip155OrderRequestPermitTransaction(
    CreateEip155OrderRequestPermitTransactionRequest
        .builder()
        .accountId("account_id")
        .body(
            Eip155OrderRequestPermitTransaction
                .builder()
                .orderRequestId("order_request_id")
                .permitSignature("permit_signature")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `Eip155OrderRequestPermitTransaction` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.orderRequests.createEip155PermitTransaction(accountId, request) -> Eip155Transaction</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Prepare a transaction to be placed on EVM. The returned structure contains the necessary
data to create an `EIP155Transaction` object.

Safe wallets can send `0x` as `permit_signature`. Those orders aren't simulated before they're returned.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.orderRequests().createEip155PermitTransaction(
    CreateEip155PermitTransactionRequest
        .builder()
        .accountId("account_id")
        .body(
            Eip155OrderRequestPermitTransaction
                .builder()
                .orderRequestId("order_request_id")
                .permitSignature("permit_signature")
                .build()
        )
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**request:** `Eip155OrderRequestPermitTransaction` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Managed Orders
<details><summary><code>client.managedOrders.createMarketBuyManagedOrderRequest(accountId, request) -> OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Create a managed `OrderRequest` to place a market buy `Order`.

Fees for the `Order` can optionally be specified in the `OrderRequest` for DFN orders in USD, supporting up to 6 decimal places

If an `OrderRequest` with the same `client_order_id` already exists for the given account, the creation call will fail.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.managedOrders().createMarketBuyManagedOrderRequest(
    CreateMarketBuyOrderRequestInput
        .builder()
        .accountId("account_id")
        .paymentAmount(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**paymentAmount:** `Double` 


Amount of currency (USD for US equities and ETFs) to pay for the order.
Must be a positive number with a precision of up to 2 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenAddress:** `Optional<String>` — Address of the payment token to be used for the payment of the order. If not provided, the default payment token (USD+) will be used.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — ID of `Stock`.
    
</dd>
</dl>

<dl>
<dd>

**alloyId:** `Optional<String>` — ID of `Alloy`.
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `Optional<String>` — ID of `Account` to receive the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied ID to map this order to an order in their own systems. Must be unique within the entity.
    
</dd>
</dl>

<dl>
<dd>

**fee:** `Optional<Double>` — Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.managedOrders.createMarketSellManagedOrderRequest(accountId, request) -> OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Create a managed `OrderRequest` to place a market sell `Order`.

Fees for the `Order` can optionally be specified in the `OrderRequest` for DFN orders in USD, supporting up to 6 decimal places

If an `OrderRequest` with the same `client_order_id` already exists for the given account, the creation call will fail.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.managedOrders().createMarketSellManagedOrderRequest(
    CreateMarketSellOrderRequestInput
        .builder()
        .accountId("account_id")
        .assetQuantity(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**assetQuantity:** `Double` — Quantity of shares to trade. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — ID of `Stock`.
    
</dd>
</dl>

<dl>
<dd>

**alloyId:** `Optional<String>` — ID of `Alloy`.
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `Optional<String>` — ID of `Account` to receive the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenAddress:** `Optional<String>` — Address of the payment token to be used for the sell order. If not provided, the default payment token (USD+) will be used. Should only be specified if `recipient_account_id` for a non-managed wallet account is also provided.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied ID to map this order to an order in their own systems. Must be unique within the entity.
    
</dd>
</dl>

<dl>
<dd>

**fee:** `Optional<Double>` — Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.managedOrders.createLimitBuyManagedOrderRequest(accountId, request) -> OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Create a managed `OrderRequest` to place a limit buy `Order`.

Fees for the `Order` can optionally be specified in the `OrderRequest` for DFN orders in USD, supporting up to 6 decimal places

If an `OrderRequest` with the same `client_order_id` already exists for the given account, the creation call will fail.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.managedOrders().createLimitBuyManagedOrderRequest(
    CreateLimitOrderBuyRequestInput
        .builder()
        .accountId("account_id")
        .assetQuantity(1.1)
        .limitPrice(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**assetQuantity:** `Double` — Amount of dShare asset involved. Required for limit `Order Requests` and market sell `Order Requests`. Must be a positive number with a precision of up to 4 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**limitPrice:** `Double` — Price at which to execute the order. Must be a positive number with a precision of up to 2 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — ID of `Stock`.
    
</dd>
</dl>

<dl>
<dd>

**alloyId:** `Optional<String>` — ID of `Alloy`.
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `Optional<String>` — ID of `Account` to receive the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied ID to map this order to an order in their own systems. Must be unique within the entity.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenAddress:** `Optional<String>` — Address of the payment token to be used for the payment of the order. If not provided, the default payment token (USD+) will be used.
    
</dd>
</dl>

<dl>
<dd>

**fee:** `Optional<Double>` — Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.managedOrders.createLimitSellManagedOrderRequest(accountId, request) -> OrderRequest</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Create a managed `OrderRequest` to place a limit sell `Order`.

Fees for the `Order` can optionally be specified in the `OrderRequest` for DFN orders in USD, supporting up to 6 decimal places

If an `OrderRequest` with the same `client_order_id` already exists for the given account, the creation call will fail.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.managedOrders().createLimitSellManagedOrderRequest(
    CreateLimitOrderSellRequestInput
        .builder()
        .accountId("account_id")
        .assetQuantity(1.1)
        .limitPrice(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**assetQuantity:** `Double` — Amount of dShare asset involved. Required for limit `Order Requests` and market sell `Order Requests`. Must be a positive number with a precision of up to 4 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**limitPrice:** `Double` — Price at which to execute the order. Must be a positive number with a precision of up to 2 decimal places.
    
</dd>
</dl>

<dl>
<dd>

**stockId:** `Optional<String>` — ID of `Stock`.
    
</dd>
</dl>

<dl>
<dd>

**alloyId:** `Optional<String>` — ID of `Alloy`.
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `Optional<String>` — ID of `Account` to receive the `Order`.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenAddress:** `Optional<String>` — Address of the payment token to be used for the sell order. If not provided, the default payment token (USD+) will be used. Should only be specified if `recipient_account_id` for a non-managed wallet account is also provided.
    
</dd>
</dl>

<dl>
<dd>

**clientOrderId:** `Optional<String>` — Customer-supplied ID to map this order to an order in their own systems. Must be unique within the entity.
    
</dd>
</dl>

<dl>
<dd>

**fee:** `Optional<Double>` — Optional fee amount associated with `Order` in USD for DFN orders. Must be a positive number with a precision of up to 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

## Withdrawals
<details><summary><code>client.withdrawals.getAccountWithdrawalRequests(accountId) -> GetAccountWithdrawalRequestsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

List `WithdrawalRequests` under the `Account`, sorted by most recent.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.withdrawals().getAccountWithdrawalRequests(
    GetAccountWithdrawalRequestsRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountWithdrawalRequestsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.withdrawals.createAccountWithdrawalRequests(accountId, request) -> WithdrawalRequest1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>


Request to withdraw USD+ payment tokens from a managed `Account` and send the equivalent amount of USDC to the specified recipient `Account`.

The recipient `Account` must belong to the same `Entity` as the managed `Account`.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.withdrawals().createAccountWithdrawalRequests(
    CreateWithdrawalRequestInput
        .builder()
        .accountId("account_id")
        .recipientAccountId("recipient_account_id")
        .paymentTokenQuantity(1.1)
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**recipientAccountId:** `String` — ID of the `Account` that will receive payment tokens from the `Withdrawal`.
    
</dd>
</dl>

<dl>
<dd>

**paymentTokenQuantity:** `Double` — Amount of USD+ payment tokens to be withdrawn. Must be greater than 0 and have at most 6 decimal places.
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.withdrawals.getAccountWithdrawalRequest(accountId, withdrawalRequestId) -> WithdrawalRequest1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `WithdrawalRequest` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.withdrawals().getAccountWithdrawalRequest(
    GetAccountWithdrawalRequestRequest
        .builder()
        .accountId("account_id")
        .withdrawalRequestId("withdrawal_request_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**withdrawalRequestId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.withdrawals.getAccountWithdrawals(accountId) -> GetAccountWithdrawalsResponse</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a list of all `Withdrawals` under the `Account`, sorted by most recent.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.withdrawals().getAccountWithdrawals(
    GetAccountWithdrawalsRequest
        .builder()
        .accountId("account_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**withdrawalRequestId:** `Optional<String>` — ID of the `WithdrawalRequest` to find `Withdrawals` for.
    
</dd>
</dl>

<dl>
<dd>

**page:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**pageSize:** `Optional<Integer>` 
    
</dd>
</dl>

<dl>
<dd>

**limit:** `Optional<Integer>` — Number of results to return
    
</dd>
</dl>

<dl>
<dd>

**order:** `Optional<GetAccountWithdrawalsRequestOrder>` — Sort order
    
</dd>
</dl>

<dl>
<dd>

**next:** `Optional<String>` — Cursor for next page
    
</dd>
</dl>

<dl>
<dd>

**previous:** `Optional<String>` — Cursor for previous page
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

<details><summary><code>client.withdrawals.getAccountWithdrawal(accountId, withdrawalId) -> Withdrawal1</code></summary>
<dl>
<dd>

#### 📝 Description

<dl>
<dd>

<dl>
<dd>

Get a specific `Withdrawal` by its ID.
</dd>
</dl>
</dd>
</dl>

#### 🔌 Usage

<dl>
<dd>

<dl>
<dd>

```java
client.withdrawals().getAccountWithdrawal(
    GetAccountWithdrawalRequest
        .builder()
        .accountId("account_id")
        .withdrawalId("withdrawal_id")
        .build()
);
```
</dd>
</dl>
</dd>
</dl>

#### ⚙️ Parameters

<dl>
<dd>

<dl>
<dd>

**accountId:** `String` 
    
</dd>
</dl>

<dl>
<dd>

**withdrawalId:** `String` 
    
</dd>
</dl>
</dd>
</dl>


</dd>
</dl>
</details>

