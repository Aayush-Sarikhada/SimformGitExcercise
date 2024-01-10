package simform.gitexcercise.android.utils

import simform.gitexcercise.android.R

sealed class ValidityType(val resId: Int) {
    class Valid(resId: Int) : ValidityType(resId)
    class InvalidUserName(resId: Int) : ValidityType(resId)
    class InvalidPassword(resId: Int) : ValidityType(resId)
}

object Validator {
    fun isLoginCredentialValid(userName: String, password: String): ValidityType {
        if (!isValidUserName(userName)) return ValidityType.InvalidUserName(resId = R.string.err_invalid_username)
        if (!isValidPassword(password)) return ValidityType.InvalidPassword(resId = R.string.err_invalid_password)
        return ValidityType.Valid(resId = R.string.msg_login_successfully)
    }

    private fun isValidUserName(username: String): Boolean {
        return username.isNotBlank() && username.length < 20
    }

    private fun isValidPassword(password: String): Boolean {
        return password.isNotBlank() && password.length in 8..20
    }
}