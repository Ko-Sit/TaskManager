package com.qulix.sitkinke.trainingtask.command;

import javax.servlet.http.HttpServletRequest;

/*
 *
 * Created by upsit on 14.06.2017.
 */
public interface ActionCommand {
    String execute(HttpServletRequest request);
}
