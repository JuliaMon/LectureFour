package ru.netology

import org.junit.Test

import org.junit.Assert.*

class TaskOneKtTest {
    @Test
    fun shouldDisplayVkLimitSinglePay() {
        // arrange
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 1500001
        val expectedResult = "Превышен лимит единичного перевода"

        // act
        val result = showVkCommission(vkMonthInPenny, currentPaymentInPenny)

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVkLimitMonthlyPay() {
        // arrange
        val vkMonthInPenny: Long = 4000001
        val currentPaymentInPenny: Long = 0
        val expectedResult = "Превышен месячный лимит переводов"

        // act
        val result = showVkCommission(vkMonthInPenny, currentPaymentInPenny)

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVkZeroComission() {
        // arrange
        val vkMonthInPenny: Long = 1900000
        val currentPaymentInPenny: Long = 1300000
        val expectedResult = "0"

        // act
        val result = showVkCommission(vkMonthInPenny, currentPaymentInPenny)

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroLimitMonthlyPay() {
        // arrange
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 60000001
        val currentPaymentInPenny: Long = 0
        val expectedResult = "Превышен месячный лимит переводов"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroTwoLimitMonthlyPay() {
        // arrange
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 60000000
        val currentPaymentInPenny: Long = 0
        val expectedResult = "Превышен месячный лимит переводов"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }


    @Test
    fun shouldDisplayMastercardOrMaestroLimitTodayPay() {
        // arrange
        val cardTodayInPenny: Long = 15000001 // 150 001 rubles
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 0
        val expectedResult = "Превышен суточный лимит перевода"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroTwoLimitTodayPay() {
        // arrange
        val cardTodayInPenny: Long = 15000000 // 150 000 rubles
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 0
        val expectedResult = "Превышен суточный лимит перевода"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroCommissionResultMonth() {
        // arrange
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 8000000
        val currentPaymentInPenny: Long = 200000
        val expectedResult = "3200"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroCommissionResultToday() {
        // arrange
        val cardTodayInPenny: Long = 7500001
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 200000
        val expectedResult = "3200"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroCommissionMonthInPennyStart() {
        // arrange
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 3750001
        val currentPaymentInPenny: Long = 3750000
        val expectedResult = "24500"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroCommissionTodayInPennyStart() {
        // arrange
        val cardTodayInPenny: Long = 3750001
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 4000000
        val expectedResult = "26000"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroCommission() {
        // arrange
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 7500001
        val expectedResult = "47000"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayMastercardOrMaestroZeroCommission() {
        // arrange
        val cardTodayInPenny: Long = 100000
        val cardMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 7400000
        val expectedResult = "0"

        // act
        val result = showMastercardOrMaestroCommission(
            cardTodayInPenny,
            cardMonthInPenny,
            currentPaymentInPenny
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVisaOrMirLimitTodayPay() {
        // arrange
        val currentPaymentInPenny: Long = 7500001
        val cardTodayInPenny: Long = 7500000
        val cardMonthInPenny: Long = 0
        val expectedResult = "Превышен суточный лимит перевода"

        // act
        val result = showVisaOrMirCommission(
            currentPaymentInPenny,
            cardTodayInPenny,
            cardMonthInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVisaOrMirLimitMonthPay() {
        // arrange
        val currentPaymentInPenny: Long = 5000001
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 55000000
        val expectedResult = "Превышен месячный лимит переводов"

        // act
        val result = showVisaOrMirCommission(
            currentPaymentInPenny,
            cardTodayInPenny,
            cardMonthInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVisaOrMirLimitMonthPayForTheTotal() {
        // arrange
        val currentPaymentInPenny: Long = 4900000
        val cardTodayInPenny: Long = 100001
        val cardMonthInPenny: Long = 55000000
        val expectedResult = "Превышен месячный лимит переводов"

        // act
        val result = showVisaOrMirCommission(
            currentPaymentInPenny,
            cardTodayInPenny,
            cardMonthInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVisaOrMirMinCommission() {
        // arrange
        val currentPaymentInPenny: Long = 10000
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 10000
        val expectedResult = "3500"

        // act
        val result = showVisaOrMirCommission(
            currentPaymentInPenny,
            cardTodayInPenny,
            cardMonthInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun shouldDisplayVisaOrMirSumCommission() {
        // arrange
        val currentPaymentInPenny: Long = 1000000
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 10000
        val expectedResult = "7500"

        // act
        val result = showVisaOrMirCommission(
            currentPaymentInPenny,
            cardTodayInPenny,
            cardMonthInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionVkPay() {
        // arrange
        val typeCard: String = "Vk Pay"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 2000000
        val currentPaymentInPenny: Long = 1000000
        val expectedResult = "0"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionMastercard() {
        // arrange
        val typeCard: String = "Mastercard"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 14000000
        val expectedResult = "86000"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionMaestro() {
        // arrange
        val typeCard: String = "Maestro"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 14300000
        val expectedResult = "87800"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionVisa() {
        // arrange
        val typeCard: String = "Visa"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 1500000
        val expectedResult = "11250"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionMir() {
        // arrange
        val typeCard: String = "Мир"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 1550000
        val expectedResult = "11625"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCommissionMirError() {
        // arrange
        val typeCard: String = "Мир"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 1550000
        val expectedResult = "13625"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun showCardTypeandAccountTypeNotSupported() {
        // arrange
        val typeCard: String = "Альфа"
        val cardTodayInPenny: Long = 0
        val cardMonthInPenny: Long = 0
        val vkMonthInPenny: Long = 0
        val currentPaymentInPenny: Long = 1550000
        val expectedResult = "Тип карты или счета не поддерживаются"

        // act
        val result = showCommission(
            typeCard,
            cardTodayInPenny,
            cardMonthInPenny,
            vkMonthInPenny,
            currentPaymentInPenny,
        )

        // assert
        assertEquals(expectedResult, result)
    }



}


//    @Test
//    fun showCommission() {
//    }
//
//    @Test
//    fun showVisaOrMirCommission() {
//    }
//
//    @Test
//    fun showMastercardOrMaestroCommission() {
//    }
//
//    @Test
//    fun showVkCommission() {
//    }
