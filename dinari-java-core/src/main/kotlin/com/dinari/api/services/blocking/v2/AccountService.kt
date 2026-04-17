// File generated from our OpenAPI spec by Stainless.

package com.dinari.api.services.blocking.v2

import com.dinari.api.core.ClientOptions
import com.dinari.api.core.RequestOptions
import com.dinari.api.core.http.HttpResponse
import com.dinari.api.core.http.HttpResponseFor
import com.dinari.api.models.v2.accounts.AccountDeactivateParams
import com.dinari.api.models.v2.accounts.AccountDeactivateResponse
import com.dinari.api.models.v2.accounts.AccountGetCashBalancesParams
import com.dinari.api.models.v2.accounts.AccountGetCashBalancesResponse
import com.dinari.api.models.v2.accounts.AccountGetDividendPaymentsParams
import com.dinari.api.models.v2.accounts.AccountGetDividendPaymentsResponse
import com.dinari.api.models.v2.accounts.AccountGetInterestPaymentsParams
import com.dinari.api.models.v2.accounts.AccountGetInterestPaymentsResponse
import com.dinari.api.models.v2.accounts.AccountGetPortfolioParams
import com.dinari.api.models.v2.accounts.AccountGetPortfolioResponse
import com.dinari.api.models.v2.accounts.AccountMintSandboxTokensParams
import com.dinari.api.models.v2.accounts.AccountRetrieveParams
import com.dinari.api.models.v2.accounts.AccountRetrieveResponse
import com.dinari.api.services.blocking.v2.accounts.ActivityService
import com.dinari.api.services.blocking.v2.accounts.OrderFulfillmentService
import com.dinari.api.services.blocking.v2.accounts.OrderRequestService
import com.dinari.api.services.blocking.v2.accounts.OrderService
import com.dinari.api.services.blocking.v2.accounts.TokenTransferService
import com.dinari.api.services.blocking.v2.accounts.WalletService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalRequestService
import com.dinari.api.services.blocking.v2.accounts.WithdrawalService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

/**
 * **`Accounts` represent the financial accounts of an `Entity`.**
 *
 * `Orders`, dividends, and other transactions are associated with an `Account`.
 */
interface AccountService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService

    /**
     * **`Wallets` represent the blockchain wallet that holds the assets of an `Account`.**
     *
     * An `Account` may be connected to a single `Wallet`.
     *
     * Individual `Entities` can connect their self-custodied `Wallets` by proving ownership of the
     * `Wallet` address. For Dinari Partners, a Dinari-managed `Wallet` can be created for the
     * Partner `Entity` in the [Dinari Partners Portal](https://Partners.dinari.com/). This may be
     * used in omnibus accounting for self-managing customers' assets.
     */
    fun wallet(): WalletService

    /**
     * **`Orders` represent the buying and selling of assets under an `Account`.**
     *
     * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by making
     * calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
     *
     * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
     * `Managed Orders` methods, which then create the corresponding transactions on the blockchain.
     */
    fun orders(): OrderService

    /**
     * **`Orders` represent the buying and selling of assets under an `Account`.**
     *
     * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by making
     * calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
     *
     * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
     * `Managed Orders` methods, which then create the corresponding transactions on the blockchain.
     */
    fun orderFulfillments(): OrderFulfillmentService

    fun orderRequests(): OrderRequestService

    /**
     * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
     * managed `Wallet` to another `Account` that is owned by the `Entity`.**
     *
     * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed by
     * Dinari and the corresponding transaction is submitted on chain.
     *
     * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted on
     * chain by Dinari. Once the transfer is submitted on chain, the corresponding `Withdrawal` is
     * created.
     *
     * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID `eip155:42161`).
     */
    fun withdrawalRequests(): WithdrawalRequestService

    /**
     * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
     * managed `Wallet` to another `Account` that is owned by the `Entity`.**
     *
     * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed by
     * Dinari and the corresponding transaction is submitted on chain.
     *
     * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted on
     * chain by Dinari. Once the transfer is submitted on chain, the corresponding `Withdrawal` is
     * created.
     *
     * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID `eip155:42161`).
     */
    fun withdrawals(): WithdrawalService

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    fun tokenTransfers(): TokenTransferService

    /**
     * **`Accounts` represent the financial accounts of an `Entity`.**
     *
     * `Orders`, dividends, and other transactions are associated with an `Account`.
     */
    fun activities(): ActivityService

    /** Get a specific `Account` by its ID. */
    fun retrieve(accountId: String): AccountRetrieveResponse =
        retrieve(accountId, AccountRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveResponse =
        retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        accountId: String,
        params: AccountRetrieveParams = AccountRetrieveParams.none(),
    ): AccountRetrieveResponse = retrieve(accountId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AccountRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: AccountRetrieveParams): AccountRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(accountId: String, requestOptions: RequestOptions): AccountRetrieveResponse =
        retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

    /** Set the `Account` to be inactive. Inactive accounts cannot be used for trading. */
    fun deactivate(accountId: String): AccountDeactivateResponse =
        deactivate(accountId, AccountDeactivateParams.none())

    /** @see deactivate */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountDeactivateResponse =
        deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see deactivate */
    fun deactivate(
        accountId: String,
        params: AccountDeactivateParams = AccountDeactivateParams.none(),
    ): AccountDeactivateResponse = deactivate(accountId, params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(
        params: AccountDeactivateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountDeactivateResponse

    /** @see deactivate */
    fun deactivate(params: AccountDeactivateParams): AccountDeactivateResponse =
        deactivate(params, RequestOptions.none())

    /** @see deactivate */
    fun deactivate(accountId: String, requestOptions: RequestOptions): AccountDeactivateResponse =
        deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

    /** Get the cash balances of the `Account`, including stablecoins and other cash equivalents. */
    fun getCashBalances(accountId: String): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none())

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, params, RequestOptions.none())

    /** @see getCashBalances */
    fun getCashBalances(
        params: AccountGetCashBalancesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): List<AccountGetCashBalancesResponse>

    /** @see getCashBalances */
    fun getCashBalances(
        params: AccountGetCashBalancesParams
    ): List<AccountGetCashBalancesResponse> = getCashBalances(params, RequestOptions.none())

    /** @see getCashBalances */
    fun getCashBalances(
        accountId: String,
        requestOptions: RequestOptions,
    ): List<AccountGetCashBalancesResponse> =
        getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

    /** Get dividend payments made to the `Account` from dividend-bearing stock holdings. */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
    ): AccountGetDividendPaymentsResponse =
        getDividendPayments(accountId, params, RequestOptions.none())

    /** @see getDividendPayments */
    fun getDividendPayments(
        accountId: String,
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetDividendPaymentsResponse =
        getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getDividendPayments */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams
    ): AccountGetDividendPaymentsResponse = getDividendPayments(params, RequestOptions.none())

    /** @see getDividendPayments */
    fun getDividendPayments(
        params: AccountGetDividendPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetDividendPaymentsResponse

    /**
     * Get interest payments made to the `Account` from yield-bearing cash holdings.
     *
     * Currently, the only yield-bearing stablecoin accepted by Dinari is
     * [USD+](https://usd.dinari.com/).
     */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
    ): AccountGetInterestPaymentsResponse =
        getInterestPayments(accountId, params, RequestOptions.none())

    /** @see getInterestPayments */
    fun getInterestPayments(
        accountId: String,
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetInterestPaymentsResponse =
        getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getInterestPayments */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams
    ): AccountGetInterestPaymentsResponse = getInterestPayments(params, RequestOptions.none())

    /** @see getInterestPayments */
    fun getInterestPayments(
        params: AccountGetInterestPaymentsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetInterestPaymentsResponse

    /** Get the portfolio of the `Account`, excluding cash equivalents such as stablecoins. */
    fun getPortfolio(accountId: String): AccountGetPortfolioResponse =
        getPortfolio(accountId, AccountGetPortfolioParams.none())

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetPortfolioResponse =
        getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
    ): AccountGetPortfolioResponse = getPortfolio(accountId, params, RequestOptions.none())

    /** @see getPortfolio */
    fun getPortfolio(
        params: AccountGetPortfolioParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccountGetPortfolioResponse

    /** @see getPortfolio */
    fun getPortfolio(params: AccountGetPortfolioParams): AccountGetPortfolioResponse =
        getPortfolio(params, RequestOptions.none())

    /** @see getPortfolio */
    fun getPortfolio(
        accountId: String,
        requestOptions: RequestOptions,
    ): AccountGetPortfolioResponse =
        getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

    /**
     * Mints 1,000 mockUSD sandbox payment tokens to the `Wallet` connected to the `Account`.
     *
     * This feature is only supported in sandbox mode.
     */
    fun mintSandboxTokens(accountId: String) =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        accountId: String,
        params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
    ) = mintSandboxTokens(accountId, params, RequestOptions.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(
        params: AccountMintSandboxTokensParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    )

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(params: AccountMintSandboxTokensParams) =
        mintSandboxTokens(params, RequestOptions.none())

    /** @see mintSandboxTokens */
    fun mintSandboxTokens(accountId: String, requestOptions: RequestOptions) =
        mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)

    /** A view of [AccountService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccountService.WithRawResponse

        /**
         * **`Wallets` represent the blockchain wallet that holds the assets of an `Account`.**
         *
         * An `Account` may be connected to a single `Wallet`.
         *
         * Individual `Entities` can connect their self-custodied `Wallets` by proving ownership of
         * the `Wallet` address. For Dinari Partners, a Dinari-managed `Wallet` can be created for
         * the Partner `Entity` in the [Dinari Partners Portal](https://Partners.dinari.com/). This
         * may be used in omnibus accounting for self-managing customers' assets.
         */
        fun wallet(): WalletService.WithRawResponse

        /**
         * **`Orders` represent the buying and selling of assets under an `Account`.**
         *
         * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by
         * making calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
         *
         * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
         * `Managed Orders` methods, which then create the corresponding transactions on the
         * blockchain.
         */
        fun orders(): OrderService.WithRawResponse

        /**
         * **`Orders` represent the buying and selling of assets under an `Account`.**
         *
         * For `Accounts` using self-custodied `Wallets`, `Orders` are created and fulfilled by
         * making calls to Dinari's smart contracts, or using the *Proxied Orders* methods.
         *
         * For `Accounts` using managed `Wallets`, `Orders` are created and fulfilled by using the
         * `Managed Orders` methods, which then create the corresponding transactions on the
         * blockchain.
         */
        fun orderFulfillments(): OrderFulfillmentService.WithRawResponse

        fun orderRequests(): OrderRequestService.WithRawResponse

        /**
         * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
         * managed `Wallet` to another `Account` that is owned by the `Entity`.**
         *
         * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed
         * by Dinari and the corresponding transaction is submitted on chain.
         *
         * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted
         * on chain by Dinari. Once the transfer is submitted on chain, the corresponding
         * `Withdrawal` is created.
         *
         * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID
         * `eip155:42161`).
         */
        fun withdrawalRequests(): WithdrawalRequestService.WithRawResponse

        /**
         * **`Withdrawals` represent the transfer of stablecoins from an `Account` connected to a
         * managed `Wallet` to another `Account` that is owned by the `Entity`.**
         *
         * Since the `Account` is backed by a managed `Wallet`, the `Withdrawal` must be processed
         * by Dinari and the corresponding transaction is submitted on chain.
         *
         * Upon requesting a withdrawal, a `WithdrawalRequest` is created, which is then submitted
         * on chain by Dinari. Once the transfer is submitted on chain, the corresponding
         * `Withdrawal` is created.
         *
         * Currently, withdrawals are made in USDC on the Arbitrum network (Chain ID
         * `eip155:42161`).
         */
        fun withdrawals(): WithdrawalService.WithRawResponse

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        fun tokenTransfers(): TokenTransferService.WithRawResponse

        /**
         * **`Accounts` represent the financial accounts of an `Entity`.**
         *
         * `Orders`, dividends, and other transactions are associated with an `Account`.
         */
        fun activities(): ActivityService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}`, but is otherwise the
         * same as [AccountService.retrieve].
         */
        @MustBeClosed
        fun retrieve(accountId: String): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(accountId, AccountRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            params: AccountRetrieveParams = AccountRetrieveParams.none(),
        ): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(accountId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AccountRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AccountRetrieveParams): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountRetrieveResponse> =
            retrieve(accountId, AccountRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/deactivate`, but is
         * otherwise the same as [AccountService.deactivate].
         */
        @MustBeClosed
        fun deactivate(accountId: String): HttpResponseFor<AccountDeactivateResponse> =
            deactivate(accountId, AccountDeactivateParams.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountDeactivateResponse> =
            deactivate(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            params: AccountDeactivateParams = AccountDeactivateParams.none(),
        ): HttpResponseFor<AccountDeactivateResponse> =
            deactivate(accountId, params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountDeactivateResponse>

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            params: AccountDeactivateParams
        ): HttpResponseFor<AccountDeactivateResponse> = deactivate(params, RequestOptions.none())

        /** @see deactivate */
        @MustBeClosed
        fun deactivate(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountDeactivateResponse> =
            deactivate(accountId, AccountDeactivateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/cash`, but is
         * otherwise the same as [AccountService.getCashBalances].
         */
        @MustBeClosed
        fun getCashBalances(
            accountId: String
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            params: AccountGetCashBalancesParams = AccountGetCashBalancesParams.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, params, RequestOptions.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            params: AccountGetCashBalancesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>>

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            params: AccountGetCashBalancesParams
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(params, RequestOptions.none())

        /** @see getCashBalances */
        @MustBeClosed
        fun getCashBalances(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<List<AccountGetCashBalancesResponse>> =
            getCashBalances(accountId, AccountGetCashBalancesParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/dividend_payments`,
         * but is otherwise the same as [AccountService.getDividendPayments].
         */
        @MustBeClosed
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
        ): HttpResponseFor<AccountGetDividendPaymentsResponse> =
            getDividendPayments(accountId, params, RequestOptions.none())

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            accountId: String,
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetDividendPaymentsResponse> =
            getDividendPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams
        ): HttpResponseFor<AccountGetDividendPaymentsResponse> =
            getDividendPayments(params, RequestOptions.none())

        /** @see getDividendPayments */
        @MustBeClosed
        fun getDividendPayments(
            params: AccountGetDividendPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetDividendPaymentsResponse>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/interest_payments`,
         * but is otherwise the same as [AccountService.getInterestPayments].
         */
        @MustBeClosed
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
        ): HttpResponseFor<AccountGetInterestPaymentsResponse> =
            getInterestPayments(accountId, params, RequestOptions.none())

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            accountId: String,
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetInterestPaymentsResponse> =
            getInterestPayments(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams
        ): HttpResponseFor<AccountGetInterestPaymentsResponse> =
            getInterestPayments(params, RequestOptions.none())

        /** @see getInterestPayments */
        @MustBeClosed
        fun getInterestPayments(
            params: AccountGetInterestPaymentsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetInterestPaymentsResponse>

        /**
         * Returns a raw HTTP response for `get /api/v2/accounts/{account_id}/portfolio`, but is
         * otherwise the same as [AccountService.getPortfolio].
         */
        @MustBeClosed
        fun getPortfolio(accountId: String): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, AccountGetPortfolioParams.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            params: AccountGetPortfolioParams = AccountGetPortfolioParams.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, params, RequestOptions.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            params: AccountGetPortfolioParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccountGetPortfolioResponse>

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            params: AccountGetPortfolioParams
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(params, RequestOptions.none())

        /** @see getPortfolio */
        @MustBeClosed
        fun getPortfolio(
            accountId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AccountGetPortfolioResponse> =
            getPortfolio(accountId, AccountGetPortfolioParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /api/v2/accounts/{account_id}/faucet`, but is
         * otherwise the same as [AccountService.mintSandboxTokens].
         */
        @MustBeClosed
        fun mintSandboxTokens(accountId: String): HttpResponse =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            mintSandboxTokens(params.toBuilder().accountId(accountId).build(), requestOptions)

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            accountId: String,
            params: AccountMintSandboxTokensParams = AccountMintSandboxTokensParams.none(),
        ): HttpResponse = mintSandboxTokens(accountId, params, RequestOptions.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(
            params: AccountMintSandboxTokensParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(params: AccountMintSandboxTokensParams): HttpResponse =
            mintSandboxTokens(params, RequestOptions.none())

        /** @see mintSandboxTokens */
        @MustBeClosed
        fun mintSandboxTokens(accountId: String, requestOptions: RequestOptions): HttpResponse =
            mintSandboxTokens(accountId, AccountMintSandboxTokensParams.none(), requestOptions)
    }
}
