/**
 * Estudiante.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombres: {
      type: 'string',
      required: true
    },

    apellidos: {
      type: 'string',
      required: true
    },

    fechaNacimiento: {
      type: 'string',
      required: true
    },

    semestreActual: {
      type: 'number',
      required: true
    },

    graduado: {
      type: 'boolean',
      required: true
    },

    materiaDeEstudiante: {     // Nombre atributo de la relación
      collection: 'materia', // Nombre del modelo a relacionar
      via: 'idEstudiante'        // Nombre del campo a hacer la relacion
    },


  },

};
