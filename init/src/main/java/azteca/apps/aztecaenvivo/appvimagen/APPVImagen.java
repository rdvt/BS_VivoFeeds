package azteca.apps.aztecaenvivo.appvimagen;

import com.psddev.cms.db.Content;
import com.psddev.dari.db.Recordable;
import com.psddev.dari.util.StorageItem;

@Recordable.PreviewField("file")
public class APPVImagen extends Content{
	private String titulo;
	private StorageItem file;

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public StorageItem getFile(){
		return file;
	}

	public void setFile(StorageItem file){
		this.file = file;
	}
}