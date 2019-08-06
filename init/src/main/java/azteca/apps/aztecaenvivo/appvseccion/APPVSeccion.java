package azteca.apps.aztecaenvivo.appvseccion;

import  azteca.apps.aztecaenvivo.appvcontenido.APPVContenido;
import  azteca.apps.aztecaenvivo.appvimagen.APPVImagen;

import com.psddev.cms.db.Content;
import com.psddev.cms.db.ToolUi; 
import com.psddev.dari.util.StringUtils;
import com.psddev.cms.db.Directory;
import com.psddev.cms.db.Site;
import com.psddev.cms.db.Directory.PathType;
import java.util.stream.Collectors;

import java.util.*;
 
public class APPVSeccion extends Content implements Directory.Item {
//Todos son tipo programa
	@ToolUi.Note("Con este nombre se puede buscar en el CMS este contenido")
	@Required
	private String nombre; 

	@ToolUi.Note("Titulo que se mostrara en el selector horizontal")
	@Required
	private String titulo;

	private List<APPVContenido> contenido;

	@ToolUi.Note("Cadena que se mandara a Firebase al entrar a esta pantalla")
	@Required
	private String screenName;
	
	@ToolUi.Note("ID de publicidad para el banner en esta pantalla")
	private String adUnitID;

	
	public String getNombre(){
		return nombre;
	}
	public String getTitulo(){
		return titulo;
	}
	public String getScreenName(){
		return screenName;
	}
	public String getAdUnitID(){
		return adUnitID;
	}
	
	public void setNombre(String y){
		this.nombre = y;
	}
	
	public void setTitulo(String y){
		this.titulo = y;
	}

	public void setScreenName(String y){
		this.screenName = y;
	}

	public void setAdUnitID(String y){
		this.adUnitID = y;
	}

	public void setContenido(List<APPVContenido> y){
		this.contenido = y;
	}
	
	public List<APPVContenido> getContenido(){
		return contenido;
	}

    public String getContenidoUrl() { 
		Directory.ObjectModification directoryData = as(Directory.ObjectModification.class);
		String permalink = directoryData.getPermalink();

		System.out.println(permalink);   
	return permalink;
	}
	
	@Override
    public String createPermalink(Site site) {
    	String name = StringUtils.toNormalized(getNombre());
        return StringUtils.toNormalized(String.format("/%s/%s", "envivoapp", name));
    }

}
