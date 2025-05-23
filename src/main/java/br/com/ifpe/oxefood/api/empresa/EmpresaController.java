package br.com.ifpe.oxefood.api.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.empesa.Empresa;
import br.com.ifpe.oxefood.modelo.empesa.EmpresaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/empresa")
@CrossOrigin
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping()
        public ResponseEntity<Empresa> save(@RequestBody EmpresaRequest request){
            Empresa empresa = empresaService.save(request.build());
            return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
        }
}
