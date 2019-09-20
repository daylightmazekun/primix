import React from 'react'
import {View, ScrollView, TextInput} from 'react-native'
import {Text, Button, CheckBox} from 'react-native-elements'
import {FormLabel, FormInputm, FormValidationMessage} from 'react-native-elements'

class EssayQuestionWidget extends React.Component {
    static navigationOption = {title: "Essay Question"}
    constructor(props){
        super(props)
        this.state = {
            title: '',
            description: '',
            points: 0,
            text: '',
            examId:'1',
            lessonId: '1'
        }
        this.submitForm = this.submitForm.bind(this)
        this.updateForm = this.updateForm.bind(this)
    }
    componentDidMount(){
        const examId = this.props.navigation.getParam("examId")
        const lessonId = this.props.navigation.getParam("lessonId")
        this.setState({
            lessonId:lessonId,
            examId: examId
        })
    }

    submitForm(examId){
        let essay = {
            title: this.state.title,
            subtitle: this.state.description,
            type: "Essay",
            points: this.state.points,
            answers: this.state.text
        }
        alert("nn")
        fetch('http://localhost:8080/api/exam/EID/essay'.replace('EID', examId), {
            body: JSON.stringify(essay),
            headers: { 'Content-Type': 'application/json' },
            method: 'POSt'
        }).then(response => (response.json()));
        this.props.navigation.navigate('QuestionList')
    }
    updatForm(newState){
        this.setState(newState)
    }

    render(){
        return(
            <ScrollView>
                <Text h4>Exam Id id {this.state.examId}</Text>
                    <FormLabel>Question Title</FormLabel>
                    <FormInput onChangeText = {
                        title => this.updateForm({title: title})
                    }/>
                    
            </ScrollView>
        )
    }
}