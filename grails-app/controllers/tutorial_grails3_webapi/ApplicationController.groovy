package tutorial_grails3_webapi

import gente.GenteService
import gente.Persona
import grails.converters.JSON

class ApplicationController{

    GenteService genteService
    
    //generado con una vista
    def index() {
        
        print genteService.get5PrimerosPelosFromPersona(genteService.getElena())
        //la pasamos como parámetro a la vista
        // por convención la vista de index() -> index.gson
        [persona: genteService.getElena()]
    }
    
    //generado por conversión
    def elena() {   
        render genteService.findPersona('Elena') as JSON
    }
    
    //generado a partir de un mapa
    def mapa() {
        
        def m = [
            nombre:"Aitor", 
            apellido:"Nillos", 
            numeroDeLaSuerte:7,
            direcciones:[
                dir1:"calle sdfsd",
                dir2:"calle xsdfasd"
            ]
        ]
        
        render (m as JSON)
    }
}
