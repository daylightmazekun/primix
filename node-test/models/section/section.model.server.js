var mongoose = require('mongoose')
var sectionSchema = require('./section.schema.server');
var sectionModel = mongoose.model('SectionModel', sectionSchema);

function createSecion(section){
    return sectionModel.create(section);
}

function findSectionForCourse(courseId){
    return sectionModel.find({courseId: courseId});
}

function decrementSectionSeats(sectionId){

    return sectionModel.update({
        _id: sectionId
    },{
        $inc: {seats: -1}
    });
}

function incrementSectionSeats(sectionId){

    return sectionModel.update({
        _id: sectionId
    },{
        $inc: {seats: +1}
    });
}

function removeSection(section){
    return sectionModel.remove(section);
}

function findSectionById(sectionId){
    return sectionModel.findOne(sectionId);
}

function updateSection(section, sectionId){
    return sectionModel.update({
        _id: sectionId
    },{
        section
    },{
        upsert: true
    });
}

module.exports = {
    createSecion : createSecion,
    findSectionForCourse: findSectionForCourse,
    decrementSectionSeats: decrementSectionSeats,
    incrementSectionSeats: incrementSectionSeats,
    removeSection: removeSection,
    updateSection: updateSection
};