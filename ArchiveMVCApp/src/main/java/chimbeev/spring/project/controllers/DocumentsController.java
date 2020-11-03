package chimbeev.spring.project.controllers;


import chimbeev.spring.project.dao.DocumentDAO;
import chimbeev.spring.project.models.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/documents")
public class DocumentsController {
    private final DocumentDAO documentDAO;

    @Autowired
    public DocumentsController(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("documents", documentDAO.index());
        return "documents/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("document", documentDAO.show(id));
        return "documents/show";
    }
    @GetMapping("/new")
    public String newDocument(@ModelAttribute("document") Document document) {
        return "documents/new";
    }
    @PostMapping
    public String create(@ModelAttribute("document") Document document) {
        documentDAO.save(document);
        return "redirect:/documents";
    }
    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("document", documentDAO.show(id));
        return "documents/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("document") Document document, @PathVariable("id") int id) {
        documentDAO.update(id, document);
        return "redirect:/documents";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")  int id) {
        documentDAO.delete(id);
        return "redirect:/documents";
    }
}
