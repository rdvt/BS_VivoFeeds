package azteca.apps.aztecaenvivo.appvseccion;
import azteca.apps.aztecaenvivo.appvimagen.APPVImagen;
import azteca.apps.aztecaenvivo.appvcontenido.APPVContenido;

import com.psddev.cms.view.JsonView;
import com.psddev.cms.view.PageEntryView;
import com.psddev.cms.view.ViewInterface;
import com.psddev.cms.view.ViewModel;
import com.psddev.cms.db.Content;
import com.psddev.dari.db.Recordable;
import com.psddev.dari.util.StorageItem;
import java.util.*;
 
@JsonView
@ViewInterface
public class APPVSeccionViewModel extends ViewModel<APPVSeccion> implements PageEntryView {

	public List<Dictionary> getDatos(){
		List<Dictionary> dRet = new ArrayList<Dictionary>();

		Dictionary dDta = new Hashtable(); 
		List<APPVContenido> lContenido = model.getContenido();
 
 		if (!lContenido.isEmpty()) {
            ListIterator<APPVContenido>  iterator = lContenido.listIterator(); 

            while (iterator.hasNext()) {
				APPVContenido item = iterator.next();
				APPVImagen imagen = item.getImagen();
				APPVImagen imgenDeFondo = item.getImagenDeFondo();
				APPVContenido.TipoCelda tipoCelda = item.getTipoDeCelda();
				String sTipo = tipoCelda.getClass().getSimpleName().toUpperCase(); 

 				

				String sImagen = getImgUrl(imagen);
				String sImagenDeFondo = getImgUrl(imgenDeFondo);
				String sTitulo = item.getTitulo();
				String sAdUnitID = model.getAdUnitID(); 

				if (sTitulo == null) 
					sTitulo = ""; 
				if (sAdUnitID == null) 
					sAdUnitID = ""; 
				 
				dDta.put("titulo", sTitulo); 
				dDta.put("imagen", sImagen); 
				dDta.put("imagenfondo", sImagenDeFondo); 
				dDta.put("adunitid",  sAdUnitID);  
				dDta.put("tipo", tipoCelda.getClass().getSimpleName().toUpperCase());  
				dDta.put("contenido", "sUrlContenido");		 
				dRet.add(dDta);
            }




		}
	
	return dRet;
	}  

	private String getImgUrl(APPVImagen img){ 
		if (img != null) {
			StorageItem file = img.getFile();
			if (file != null) {
				return file.getPublicUrl();
			}
		}

		return "";
	}

	/*
	public List<Dictionary> getDatos(){
		List<Dictionary> dRet = new ArrayList<Dictionary>();
		Dictionary dDta = new Hashtable(); 
		String sTitle = model.getTitulo();
		String sTipo = "PROGRAMA";
		String sScreenName = model.getScreenName();
		String sAdUnitID = model.getAdUnitID();
		List<APPVContenido> lContenido = model.getContenido();
 
 String sUrlContenido = model.getContenidoUrl();

		if (sTitle == null) 
			sTitle = ""; 
		if (sAdUnitID == null) 
			sAdUnitID = ""; 
		if(sScreenName == null){
			sScreenName = "No configurado";
		}

		dDta.put("titulo", sTitle); 
		dDta.put("tipo", sTipo); 
		dDta.put("screenname",   sScreenName); 
		dDta.put("adunitid",  sAdUnitID);  
		dDta.put("contenido", sUrlContenido);		 
		dRet.add(dDta);
	
	return dRet;
	}  
	*/

}