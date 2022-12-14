package filejava.gui;

import filejava.core.EleveGommettesCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class EleveGommettesGUI{
    public static String getAllEleveGommettes(int id) throws IOException, TemplateException{
        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();
        input.put("elevegommettes", EleveGommettesCore.getAllEleveGommettes(id));
        input.put("eleveid", id);
        Writer output = new StringWriter();
        Template template = configuration.getTemplate("/elevegommettes.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}