package com.ruiskas.jurassicworldtoy.domain.error

sealed class Failure(val message: String? = null) {
    class GenericFailure(val code: Int = 0, message: String? = null) : Failure(message)

    class ServerError(val msg: String?) : Failure(msg)
    object Timeout : Failure()
    object UnknownHost : Failure()
    class JsonFormat(val msg: String?) : Failure(msg)

    class MissingParameter(val msg: String?) : Failure(msg)
    class NoData(val msg: String?) : Failure(msg)
    object NoSession : Failure()

    //Nfc
    object NfcDisabled : Failure()
    object NfcNotSupported : Failure()
    class NfcReadError(val msg: String?) : Failure(msg)

    //Network
    object NetworkConnection : Failure()

    //Firebase
    class FirebaseParserError(val msg: String?) : Failure(msg)
    class FirebaseEventCancelled(val msg: String?) : Failure(msg)
    class FirebaseFailure(val msg: String?) : Failure(msg)
}