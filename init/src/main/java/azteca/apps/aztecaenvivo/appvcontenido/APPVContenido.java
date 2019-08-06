package azteca.apps.aztecaenvivo.appvcontenido;

import azteca.apps.aztecaenvivo.appvimagen.APPVImagen;
import com.psddev.cms.db.Content;
import com.psddev.cms.db.ToolUi;
import com.psddev.dari.db.*;
import com.psddev.dari.util.*;
import java.util.*;

public class APPVContenido extends Content {
	@ToolUi.Note("Con este nombre se puede buscar en el CMS este contenido")
	@Required
	private String nombre;

	private String titulo;

	@ToolUi.Note("Imagen que se muestra en primer plano de la celda en el listado de contenido")
	private APPVImagen imagen;

	@ToolUi.Note("Imagen que se muestra en el fondo de la celda en el listado de contenido, esta imagen se puede expandir")
	private APPVImagen imagenDeFondo;
	 
	@ToolUi.Note("Ad Unit ID para mostrar el banner de publicidad")
	@Required
	private String adUnitId;

	@ToolUi.Note("Los diferentes tipos de contenido que muestra el App")
	@Required
	private TipoCelda tipoDeCelda;
	 

    @Recordable.Embedded
    public abstract static class TipoCelda extends Record  {
		@ToolUi.Note("Valor que se mandara a Firebase al mostrar la ventana")
		@Required
		String screenName;
		 
	}

    public static class Video01 extends TipoCelda {
		@ToolUi.Note("URL al video, el cual se muestra con un titulo y boton ver, sin espacio debajo de la imagen")
		@Required
		String contenido;

		@ToolUi.Note("El Vast para el pre rol") 
		String vast;

		@ToolUi.Hidden
	 	String tipo ="VIDEO01";
    }

    public static class Video02 extends TipoCelda {
		@ToolUi.Note("URL al video, el cual se muestra con un titulo y boton ver en el espacio debajo de la imagen")
		@Required
		String contenido;

		@ToolUi.Note("El Vast para el pre rol") 
		String vast;

		@ToolUi.Hidden
		String tipo ="VIDEO02";
    }

    public static class HTML extends TipoCelda { 
		@ToolUi.Note("URL al contenido html")
		@Required
		String contenido;


		@ToolUi.Hidden
		String tipo ="HTML";
    }

	public static class ListaHorizontal extends TipoCelda { 
		@ToolUi.Note("URL al contenido html")
		@Required
		List <APPVContenido> items;

		@ToolUi.Hidden
		String tipo ="LSTHOR";
    }
	 
	public String getTitulo(){
		return titulo.trim();
	}
  
	public String getNombre(){
		return nombre.trim();
	}
	   
	public APPVImagen getImagen(){
		return imagen;
	}

	public APPVImagen getImagenDeFondo(){
		return imagenDeFondo;
	} 

	 public String getAdUnitId(){
		return adUnitId.trim();
	 } 

	public void setTitulo(String y){
		this.titulo = y;
	} 

	public void setNombre(String y){
		this.nombre = y;
	} 

	public void setImagen(APPVImagen y){
		this.imagen = y;
	}

	public void setImagenDeFondo(APPVImagen y){
		this.imagenDeFondo = y;
	}

	public void setAUnitId(String y){
		this.adUnitId = y;
	}

	public TipoCelda getTipoDeCelda(){
		return tipoDeCelda;
	}
	  
}

 