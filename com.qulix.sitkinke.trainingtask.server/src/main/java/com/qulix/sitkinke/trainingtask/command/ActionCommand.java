package com.qulix.sitkinke.trainingtask.command;

import javax.servlet.http.HttpServletRequest;

/**
 * Interface that describes basic command method.
 *
 * @author sitkin
 */
public interface ActionCommand {

    /**
     * Works with request.
     *
     * @param request the request
     * @return string the next jsp path
     */
    String execute(HttpServletRequest request);
}
