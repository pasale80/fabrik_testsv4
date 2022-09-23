package it.pascal.fabrik.testsv4.utils;

import javax.servlet.http.HttpServletRequest;

public final class UriUtils {

    private UriUtils(){

    }
    public static String buildUri(HttpServletRequest request) {
        String uri = new StringBuilder()
                .append(request.getRequestURI())
                .append("?")
                .append(request.getQueryString()).toString();
        return uri;
    }
}
