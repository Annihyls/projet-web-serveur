package filejava.gui;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class indexGUI{
    public static String getIndex() throws IOException, TemplateException{
        Configuration configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input = new HashMap<>();
        input = null;
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/index.html");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}