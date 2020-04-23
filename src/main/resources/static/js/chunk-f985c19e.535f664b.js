(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f985c19e","chunk-2d215c9f"],{"1a9a":function(t,e,o){"use strict";var n=o("c7a6"),i=o.n(n);i.a},"979f":function(t,e,o){"use strict";o.r(e);var n=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("section",{staticClass:"todoapp"},[o("header",{staticClass:"header"},[o("input",{staticClass:"new-todo",attrs:{autocomplete:"off",placeholder:"Todo List"},on:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.addTodo(e)}}})]),t._v(" "),o("section",{directives:[{name:"show",rawName:"v-show",value:t.todos.length,expression:"todos.length"}],staticClass:"main"},[o("input",{staticClass:"toggle-all",attrs:{id:"toggle-all",type:"checkbox"},domProps:{checked:t.allChecked},on:{change:function(e){return t.toggleAll({done:!t.allChecked})}}}),t._v(" "),o("label",{attrs:{for:"toggle-all"}}),t._v(" "),o("ul",{staticClass:"todo-list"},t._l(t.filteredTodos,function(e,n){return o("todo",{key:n,attrs:{todo:e},on:{toggleTodo:t.toggleTodo,editTodo:t.editTodo,deleteTodo:t.deleteTodo}})}),1)]),t._v(" "),o("footer",{directives:[{name:"show",rawName:"v-show",value:t.todos.length,expression:"todos.length"}],staticClass:"footer"},[o("span",{staticClass:"todo-count"},[o("strong",[t._v(t._s(t.remaining))]),t._v("\n      "+t._s(t._f("pluralize")(t.remaining,"item"))+" left\n    ")]),t._v(" "),o("ul",{staticClass:"filters"},t._l(t.filters,function(e,n){return o("li",{key:n},[o("a",{class:{selected:t.visibility===n},on:{click:function(e){e.preventDefault(),t.visibility=n}}},[t._v(t._s(t._f("capitalize")(n)))])])}),0)])])},i=[],s=(o("ac6a"),o("f499")),d=o.n(s),a=o("c062"),l="todos",r={all:function(t){return t},active:function(t){return t.filter(function(t){return!t.done})},completed:function(t){return t.filter(function(t){return t.done})}},c=[{text:"star this repository",done:!1},{text:"fork this repository",done:!1},{text:"follow author",done:!1},{text:"vue-element-admin",done:!0},{text:"vue",done:!0},{text:"element-ui",done:!0},{text:"axios",done:!0},{text:"webpack",done:!0}],u={components:{Todo:a["default"]},filters:{pluralize:function(t,e){return 1===t?e:e+"s"},capitalize:function(t){return t.charAt(0).toUpperCase()+t.slice(1)}},data:function(){return{visibility:"all",filters:r,todos:c}},computed:{allChecked:function(){return this.todos.every(function(t){return t.done})},filteredTodos:function(){return r[this.visibility](this.todos)},remaining:function(){return this.todos.filter(function(t){return!t.done}).length}},methods:{setLocalStorage:function(){window.localStorage.setItem(l,d()(this.todos))},addTodo:function(t){var e=t.target.value;e.trim()&&(this.todos.push({text:e,done:!1}),this.setLocalStorage()),t.target.value=""},toggleTodo:function(t){t.done=!t.done,this.setLocalStorage()},deleteTodo:function(t){this.todos.splice(this.todos.indexOf(t),1),this.setLocalStorage()},editTodo:function(t){var e=t.todo,o=t.value;e.text=o,this.setLocalStorage()},clearCompleted:function(){this.todos=this.todos.filter(function(t){return!t.done}),this.setLocalStorage()},toggleAll:function(t){var e=this,o=t.done;this.todos.forEach(function(t){t.done=o,e.setLocalStorage()})}}},f=u,h=(o("1a9a"),o("2877")),g=Object(h["a"])(f,n,i,!1,null,null,null);e["default"]=g.exports},a21f:function(t,e,o){var n=o("584a"),i=n.JSON||(n.JSON={stringify:JSON.stringify});t.exports=function(t){return i.stringify.apply(i,arguments)}},c062:function(t,e,o){"use strict";o.r(e);var n=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("li",{staticClass:"todo",class:{completed:t.todo.done,editing:t.editing}},[o("div",{staticClass:"view"},[o("input",{staticClass:"toggle",attrs:{type:"checkbox"},domProps:{checked:t.todo.done},on:{change:function(e){return t.toggleTodo(t.todo)}}}),t._v(" "),o("label",{domProps:{textContent:t._s(t.todo.text)},on:{dblclick:function(e){t.editing=!0}}}),t._v(" "),o("button",{staticClass:"destroy",on:{click:function(e){return t.deleteTodo(t.todo)}}})]),t._v(" "),o("input",{directives:[{name:"show",rawName:"v-show",value:t.editing,expression:"editing"},{name:"focus",rawName:"v-focus",value:t.editing,expression:"editing"}],staticClass:"edit",domProps:{value:t.todo.text},on:{keyup:[function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.doneEdit(e)},function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"esc",27,e.key,["Esc","Escape"])?null:t.cancelEdit(e)}],blur:t.doneEdit}})])},i=[],s={name:"Todo",directives:{focus:function(t,e,o){var n=e.value,i=o.context;n&&i.$nextTick(function(){t.focus()})}},props:{todo:{type:Object,default:function(){return{}}}},data:function(){return{editing:!1}},methods:{deleteTodo:function(t){this.$emit("deleteTodo",t)},editTodo:function(t){var e=t.todo,o=t.value;this.$emit("editTodo",{todo:e,value:o})},toggleTodo:function(t){this.$emit("toggleTodo",t)},doneEdit:function(t){var e=t.target.value.trim(),o=this.todo;e?this.editing&&(this.editTodo({todo:o,value:e}),this.editing=!1):this.deleteTodo({todo:o})},cancelEdit:function(t){t.target.value=this.todo.text,this.editing=!1}}},d=s,a=o("2877"),l=Object(a["a"])(d,n,i,!1,null,null,null);e["default"]=l.exports},c7a6:function(t,e,o){},f499:function(t,e,o){t.exports=o("a21f")}}]);