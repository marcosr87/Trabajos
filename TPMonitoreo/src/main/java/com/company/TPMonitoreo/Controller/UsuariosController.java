package com.company.TPMonitoreo.Controller;

import com.company.TPMonitoreo.Model.Usuario;
import com.company.TPMonitoreo.Repository.Interfaces.IUsuarioDAO;
import net.sf.uadetector.OperatingSystem;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alumno on 24/04/2018.
 */
@RestController

public class UsuariosController {


    @Autowired
    public IUsuarioDAO UsuarioDAO;





      @RequestMapping(value = "/")
    public void Informacion(@RequestHeader (value = "User-Agent") String userAgent ){
        UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
        ReadableUserAgent agent = parser.parse(userAgent);
      //  VersionNumber browserVersion = agent.getVersionNumber();
        OperatingSystem os = agent.getOperatingSystem();

        Usuario Usr = new Usuario(os.getName(),agent.getName());
        UsuarioDAO.save(Usr);

    }

    //Devuelve todos los Usuarios
    @RequestMapping(value = "/traerTodos")
    public List<Usuario> traerTodos(){
        List<Usuario> lista = UsuarioDAO.findAll();

        return lista;
    }

    //Navegador mas utilizado
    @RequestMapping(value = "/browser")
    public String navegadorMasUtilizado(){
        String navegador;
        int countChrome = 0;
        int countExplorer = 0;
        List<Usuario> lista = traerTodos();

        for(Usuario e : lista){
            if (e.getNombreBrowser().equals("Chrome")){
                countChrome++;
            }
            else{
                countExplorer++;
            }
        }

        if(countChrome >= countExplorer){
            navegador = "Chrome";
        }
        else{
            navegador = "Internet Explorer";
        }

        return navegador;
    }


    //Sistema Operativo mas utilizado
    @RequestMapping(value = "/sistemaOperativo")
    public String sistemaMasUtilizado(){
        List<Usuario> lista = traerTodos();
        int countWindows = 0;
        int countLinux = 0;
        String SO;

        for(Usuario e : lista){
            if(e.getNombreSO().equals("Windows 8.1")){
                countWindows++;
            }
            else
                countLinux++;
        }

        if(countWindows >= countLinux)
            SO = "Windows 8.1";
        else
            SO = "Linux";

        return SO;
    }
}



