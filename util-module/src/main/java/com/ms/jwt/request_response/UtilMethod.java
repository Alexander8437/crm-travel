package com.ms.jwt.request_response;

public class UtilMethod {
	public static String extractDetailMessage(String errorMessage) {
        // Example error message: "ERROR: duplicate key value violates unique constraint \"uk_ofx66keruapi6vyqpv6f2or37\"\n  Detail: Key (name)=(ACCOUNTANT) already exists."
        if (errorMessage != null && errorMessage.contains("Detail: Key")) {
           String[] msg=errorMessage.split("Detail: Key \\(name\\)=");
           
           return msg[1];
        }
        return "A duplicate entry already exists.";
    }
}
