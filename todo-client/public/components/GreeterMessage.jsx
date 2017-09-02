import React from 'react';

export default class GreeterMessage extends React.Component {

    render() {
        var {name, description} = this.props;
        return (
            <div style={{textAlign: 'center'}}>
                You are <b>{name}</b>. Below are your details:-
                <div>
                    <i style={{color:'#a72f6f'}}>{description}</i>
                </div>
            </div>
        );
    }
}