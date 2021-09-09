<template>
  <textarea ref="mycode" v-model="code" placeholder="按Ctrl键进行代码提示" class="codesql" style="height:200px;width:600px;"/>
</template>

<script>
import 'codemirror/theme/ambiance.css'
import 'codemirror/lib/codemirror.css'
import 'codemirror/addon/hint/show-hint.css'

const CodeMirror = require('codemirror/lib/codemirror')
require('codemirror/addon/edit/matchbrackets')
require('codemirror/addon/selection/active-line')
require('codemirror/mode/sql/sql')
require('codemirror/addon/hint/show-hint')
require('codemirror/addon/hint/sql-hint')
import sqlFormatter from 'sql-formatter'

export default {
  name: "SqlArea",
  components: {},
  data() {
    return {
      sql: '',
      "options:": {}
    }
  },
  methods: {
    onChange(value) {
      console.log(value);
    },
    format() {
      /* 获取文本编辑器内容*/
      let sqlContent = ''
      sqlContent = this.editor.getValue()
      /* 将sql内容进行格式后放入编辑器中*/
      this.editor.setValue(sqlFormatter.format(sqlContent))
    }
  },
  mounted() {
    const mime = 'text/x-mariadb'
    // let theme = 'ambiance'//设置主题，不设置的会使用默认主题
    this.editor = CodeMirror.fromTextArea(this.$refs.mycode, {
      mode: mime, // 选择对应代码编辑器的语言，我这边选的是数据库，根据个人情况自行设置即可
      indentWithTabs: true,
      smartIndent: true,
      lineNumbers: true,
      matchBrackets: true,
      // theme: 'base16-light',
      // autofocus: true,
      extraKeys: {'Ctrl': 'autocomplete'}, // 自定义快捷键
      hintOptions: {// 自定义提示选项
        tables: {
          users: ['1112', '123123', '124124'],
          countries: ['124', '124124', '1']
        }
      }
    })
    this.editor.on('cursorActivity', () => {
      this.editor.showHint()
    })
  }
}
</script>

<style scoped>

</style>