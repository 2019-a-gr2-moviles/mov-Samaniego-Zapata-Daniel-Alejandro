/**
 * Materia.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    nombre: {
      type: 'string',
      required: true
    },

    descripcion: {
      type: 'string',
      required: true
    },

    codigo: {
      type: 'string',
      required: true
    },

    fechaCreacion: {
      type: 'string',
      required: true
    },

    numeroHorasPorSemana: {
      type: 'number',
      required: true
    },

    longitud: {
      required: true,
      type: 'string'
    },

    latitud: {
      required: true,
      type: 'string'
    },

    idEstudiante: {         // Nombre del fk para la relación
      model: 'estudiante',   // Nombre del modelo a relacionar (padre) 
      required: true   // OPCIONAL-> Simpre se ingrese el fk
    }

  },

};

