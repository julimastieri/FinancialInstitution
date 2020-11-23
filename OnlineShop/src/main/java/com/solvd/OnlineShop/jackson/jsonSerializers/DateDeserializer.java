package com.solvd.OnlineShop.jackson.jsonSerializers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateDeserializer extends StdDeserializer<Date> {
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat formatter
      = new SimpleDateFormat("dd-MM-yyyy");
 
    public DateDeserializer() { 
        this(null); 
    } 
 
    public DateDeserializer(Class<?> vc) { 
        super(vc); 
    }
 
    @Override
    public Date deserialize(
      JsonParser jsonparser, DeserializationContext  context) 
      throws IOException {
        
        String date = jsonparser.getText();
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
