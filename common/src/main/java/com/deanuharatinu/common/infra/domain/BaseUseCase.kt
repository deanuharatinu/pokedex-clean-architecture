package com.deanuharatinu.common.infra.domain

abstract class BaseUseCase<REQUEST, RESULT> {
    abstract fun execute(request: REQUEST): RESULT
}