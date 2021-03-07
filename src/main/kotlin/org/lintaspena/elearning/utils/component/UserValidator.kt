package org.lintaspena.elearning.utils.component

import org.lintaspena.elearning.moduls.userrole.model.User
import org.lintaspena.elearning.moduls.userrole.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator


@Component
class UserValidator : Validator {

    @Autowired
    private val userService: UserService? = null

    override fun supports(aClass: Class<*>): Boolean {
        return User::class.java == aClass
    }

    override fun validate(o: Any, errors: Errors) {
        val user = o as User
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty")
        if (user.userName?.length!! < 6 || user.userName?.length!! > 32) {
            errors.rejectValue("username", "Size.userForm.username")
        }
        if (userService?.findByUserName(user.userName!!) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username")
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty")
        if (user.password?.length!! < 8 || user.password?.length!! > 32) {
            errors.rejectValue("password", "Size.userForm.password")
        }
        if (!user.passwordConfirmation.equals(user.password)) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm")
        }
    }
}