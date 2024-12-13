package pe.edu.cibertec.t2_daw1_juarez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.t2_daw1_juarez.entities.Empleado;
import pe.edu.cibertec.t2_daw1_juarez.respository.EmpleadoRepository;

@Controller
@RequestMapping("empleados")
@AllArgsConstructor
public class EmpleadosController {

    EmpleadoRepository empleadoRepository;

    // @RequestMapping(path = "personas", method=RequestMethod.GET)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("listaEmpleados", empleadoRepository.findAll());
        return "empleado/list";
    }

    // @RequestMapping(path="empleados/nueva", method=RequestMethod.GET)
    @GetMapping("nueva") //personas/nueva
    public String showFormCreate(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleado/create.html";
    }

    // @RequestMapping(path="personas/nueva", method=RequestMethod.POST)
    @PostMapping("nueva")
    public String create(@ModelAttribute Empleado empleado) {
        try {
            empleadoRepository.save(empleado);
            System.out.println("Empleado guardado: " + empleado);
        } catch (Exception e) {
            System.err.println("Error al guardar el empleado: " + e.getMessage());
            e.printStackTrace();
        }
        return "redirect:/empleados";
    }
    

    @PostMapping("eliminar/{id}")
    public String delete(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados";
    }

    @GetMapping("{id}")
    public String showFormEdit(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow();
        model.addAttribute("empleado", empleado);
        return "empleado/edit";
    }

    @PostMapping("{id}")
    public String edit(@PathVariable Long id, Empleado empleado) {
        Empleado empleadoBd = empleadoRepository.findById(id).orElseThrow();
        empleadoBd.setNombre(empleado.getNombre());
        empleadoBd.setApellido(empleado.getApellido());
        empleadoBd.setPuesto(empleado.getPuesto());
        empleadoBd.setSalario(empleado.getSalario());
        empleadoRepository.save(empleadoBd);
        return "redirect:/empleados";
    }

    @GetMapping("/nosotros")
    public String mostrarNosotros() {
        return "empleado/nosotros"; // El nombre de la vista con la ruta correcta
    }
    
    
}

