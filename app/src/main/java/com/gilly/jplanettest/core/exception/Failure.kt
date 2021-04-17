package com.gilly.jplanettest.core.exception

sealed class Failure(val errorMsg: String? = null) {
    object NetworkConnection : Failure()
    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()

    object FileFailure : FeatureFailure()
    object RoomFailure : FeatureFailure()
    object TimeoutFailure : FeatureFailure()
    object ServerFailure : FeatureFailure()
    object NetworkFailure : FeatureFailure()
}