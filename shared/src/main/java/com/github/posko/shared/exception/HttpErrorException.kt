package com.github.posko.shared.exception

import java.lang.Exception

class HttpErrorException(code : Int, message : String) : Exception(message)