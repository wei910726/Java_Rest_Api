package com.example.demo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Gab on 2017/7/26.
 */
@ControllerAdvice
public class ErrorHandle {
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Error<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        Error<String> r = new Error<>();
        r.setMessage(e.getMessage());
        r.setCode(Error.ERROR);
        r.setData("Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


}
