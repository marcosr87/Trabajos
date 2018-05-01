package com.company.TPMonitoreo.Repository.Interfaces;

import com.company.TPMonitoreo.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alumno on 24/04/2018.
 */
public interface IUsuarioDAO  extends JpaRepository<Usuario,Long>{

    //Usuario findbyId(long id,String Browser, String So);


}
