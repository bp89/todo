import React from 'react';
import GreeterForm from './GreeterForm.jsx'
import GreeterMessage from './GreeterMessage.jsx'


export default class Greeter extends React.Component {
    constructor(props) {
        super(props);
        this.state =  {
            name: "Vinay",
            description: "Vinay is a technology enthusiast."
        };
    }

    render() {
       var  syncSubmitForm = (name, description) =>{
            console.log("sync submit form...")
            console.log(name)
            console.log(description)
            this.setState({
                name: name,
                description: description
            })
        }

        var {name, description} = this.state;
        return (
            <div style={{textAlign: 'center'}}>
                This is a sample application...
                <GreeterForm submitForm={syncSubmitForm}/>
                <hr/>
                <GreeterMessage name={name} description={description}/>
            </div>
        );
    }
}