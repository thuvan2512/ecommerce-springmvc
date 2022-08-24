/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thunv.formatters;

import com.thunv.pojo.AgentField;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author thu.nv2512
 */
public class AgentFieldFormatter implements Formatter<AgentField>{

    @Override
    public String print(AgentField t, Locale locale) {
        return String.valueOf(t.getAfID());
    }

    @Override
    public AgentField parse(String afID, Locale locale) throws ParseException {
        AgentField a = new AgentField();
        a.setAfID(Integer.parseInt(afID));
        return a;
    }
    
}
