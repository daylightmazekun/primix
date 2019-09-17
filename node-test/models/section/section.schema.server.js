var mongoose = require('mongoose');
var sectionSchema = mongoose.Schema({
    name: String,
    seats: { type: Number,
            default: 0
        },
    courseId: Number,
    student: [String]
}, {
    collection: 'section'
})
module.exports = sectionSchema;