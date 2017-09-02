import React from 'react';

export default class GreeterForm extends React.Component {
    submitForm(e) {
        e.preventDefault();
        var name = this.refs.name.value;
        var description = this.refs.description.value;
        this.props.submitForm(name,description)
    }

    render() {

        return (
            <div style={{textAlign: 'center'}}>
                <form>
                    Name : <input type="text" placeholder="Input Name" ref="name"/>
                    <hr/>
                    Description: <textarea cols="50" rows="10" ref="description"
                                           placeholder="Your details go here..."></textarea>
                    <hr/>
                    <button onClick={(e)=>this.submitForm(e)}>Submit</button>
                </form>
            </div>
        );
    }
}