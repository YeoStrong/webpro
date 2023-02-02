import './App.css';
import React, { Component } from 'react';
import Subject from './components/Subject';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent';

class App extends Component{
  constructor(props){
    super(props);
    this.state = {
      selected_content_id : 1,
      mode : 'read', // create, update, delete
      subject : {title:'WEB', sub:'World Wide Web!'},
      contents : [
        {id:1, title:'HTML', desc:'HTML is HyperText Markup Language.'},
        {id:3, title:'CSS', desc:'CSS is for design.'},
        {id:4, title:'JavaScript', desc:'JavaScript is for interactive'},
      ],
      welcome : {title:'WELCOME', desc: 'Hello, React!!!'},
    };
  }

  render(){
    console.log('App render');
    var _title, _desc = null;
    if(this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
    }else if(this.state.mode === 'read'){
      for(var idx=0 ; idx<this.state.contents.length ; idx++){
        var data = this.state.contents[idx];
        if(data.id === this.state.selected_content_id){
          _title = data.title;
          _desc = data.desc;
          break;
        } // if
      } // for
    } // if(mode)
    return (
      <div>
        <Subject title={this.state.subject.title} 
        sub={this.state.subject.sub}
        onChangePage={function(){
          this.setState({
            mode : 'welcome',
          });
        }.bind(this)}></Subject>
        <TOC data={this.state.contents} onChangePage={function(id){
          this.setState({
            mode : 'read',
            selected_content_id : Number(id),
          });
        }.bind(this)}></TOC>
        <ReadContent title={_title} desc={_desc}></ReadContent>
      </div>
    );
  }
}

export default App;
