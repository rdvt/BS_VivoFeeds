package azteca.apps.aztecaenvivo.appvseccion;

import  azteca.apps.aztecaenvivo.appvcontenido.APPVContenido;
import  azteca.apps.aztecaenvivo.appvimagen.APPVImagen;

import com.psddev.cms.db.Content;
import com.psddev.cms.db.ToolUi; 
import com.psddev.dari.util.StringUtils;
import com.psddev.cms.db.Directory;
import com.psddev.cms.db.Site;

import java.util.*;
 
public class APPVSeccion extends Content implements Directory.Item {
//Todos son tipo programa
	@ToolUi.Note("Con este nombre se puede buscar en el CMS este contenido")
	@Required
	private String nombre; 

	private String titulo;

	private List<APPVContenido> contenido;

	private String screenName;
	private String adUnitID;

	@Override
    public String createPermalink(Site site) {
        return StringUtils.toNormalized(getHeadline());
    }

}
