package org.academiadecodigo.rapunshells.controller.web;

import org.academiadecodigo.rapunshells.command.CarerDto;
import org.academiadecodigo.rapunshells.converters.CarerDtoToCarer;
import org.academiadecodigo.rapunshells.converters.CarerToCarerDto;
import org.academiadecodigo.rapunshells.exceptions.AssociationExistsException;
import org.academiadecodigo.rapunshells.exceptions.CarerNotFoundException;
import org.academiadecodigo.rapunshells.persistence.model.Carer;
import org.academiadecodigo.rapunshells.services.CarerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/carer")
public class CarerController {

    private CarerService carerService;

    private CarerToCarerDto carerToCarerDto;
    private CarerDtoToCarer carerDtoToCarer;

    @Autowired
    public void setCarerService(CarerService carerService) {
        this.carerService = carerService;
    }

    @Autowired
    public void setCarerToCarerDto(CarerToCarerDto carerToCarerDto) {
        this.carerToCarerDto = carerToCarerDto;
    }

    @Autowired
    public void setCarerDtoToCarer(CarerDtoToCarer carerDtoToCarer) {
        this.carerDtoToCarer = carerDtoToCarer;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public String listCarers(Model model) {
        model.addAttribute("carers", carerToCarerDto.convert(carerService.list()));
        return "carer/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addCarer(Model model) {
        model.addAttribute("carer", new CarerDto());
        return "carer/add-update";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/edit")
    public String editCarer(@PathVariable Integer id, Model model) {
        model.addAttribute("carer", carerToCarerDto.convert(carerService.get(id)));
        return "carer/add-update";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showCarer(@PathVariable Integer id, Model model) throws Exception {

        Carer carer = carerService.get(id);

        model.addAttribute("carer", carerToCarerDto.convert(carer));

        return "carer/show";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=save")
    public String saveCarer(@Valid @ModelAttribute("carer") CarerDto carerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "carer/add-update";
        }

        Carer savedCarer = carerService.save(carerDtoToCarer.convert(carerDto));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCarer.getFirstName() + " " + savedCarer.getLastName());
        return "redirect:/carer/" + savedCarer.getId();
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, params = "action=cancel")
    public String cancelSaveCarer() {
        return "redirect:/carer/";
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}/delete")
    public String deleteCarer(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws AssociationExistsException, CarerNotFoundException {
        Carer carer = carerService.get(id);
        carerService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + carer.getFirstName() + " " + carer.getLastName());
        return "redirect:/carer";
    }
}
