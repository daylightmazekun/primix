import * as constants from "../constants/index"

export const WidgetReducer = (state ={
    widgets:[],
    topicId:"",
    preview: false},
    action) =>{
        switch(action.type){
            case 'FIND_WIDGETS_TOPIC':return{
                widgets:action.widgets,
                topicId:action.topicId
            }

            case  constants.ADD:return{
                widgets:[...state.widgets,
                    {
                        topicId:action.topicId,
                        id:state.widgets.length+1,
                        widgetType:'Heading',
                        size:'1',
                        widgetName:'',
                        orderWidget:state.orderWidget
                    }
                ],
                topicId:action.topicId
            }
            case constants.DELETE_WIDGET: return {
                widgets: state.widgets.filter(widget =>{
                    widget.id !== action.widgetId
                }),
                topicId:action.topicId
            }
        }
    }
    )