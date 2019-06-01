package com.example.MysqlAndLanbdaAndError;

public class CustException extends Exception{
    public CustException(long id) {
        super("your id not found in database="+id);
    }
}
