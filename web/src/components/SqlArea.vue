<template>
    <div>
        <el-row ref="editor_bar" style="padding-bottom: 10px">
            <el-button icon="el-icon-s-promotion" round type="primary" plain>执行</el-button>
            <el-button icon="el-icon-brush" round  @click="format()" type="success" plain>格式化</el-button>
            <el-button icon="el-icon-search" circle></el-button>
        </el-row>
            <textarea ref="mycode" v-model="code"/>
    </div>
</template>

<script>

import 'codemirror/theme/ambiance.css'
import '../style/codemirror.css'
import 'codemirror/addon/hint/show-hint.css'

const CodeMirror = require('codemirror/lib/codemirror')
require('codemirror/addon/edit/matchbrackets')
require('codemirror/addon/selection/active-line')
require('codemirror/mode/sql/sql')
require('codemirror/addon/hint/show-hint')
require('codemirror/addon/hint/sql-hint')
import sqlFormatter from 'sql-formatter'
import '../assets/icon/iconfont.css'


export default {
    name: "SqlEditor",
    data() {
        return {
            code: '',
            editor: null,
        };
    },
    methods: {
        format() {
            /* 获取文本编辑器内容*/
            let sqlContent = ''
            sqlContent = this.editor.getValue()
            console.info(sqlContent)
            /* 将sql内容进行格式后放入编辑器中*/
            var fomated_sql = sqlFormatter.format(sqlContent);
            this.editor.setValue(fomated_sql)
        },
    },
    mounted() {
        this.editor = CodeMirror.fromTextArea(this.$refs.mycode, {
            tabSize: 4,
            mode: "text/x-mysql",
            indentWithTabs: true,
            smartIndent: true,
            matchBrackets: true,
            theme: 'base16-light',
            lineNumbers: true,
            line: true,
            lineWrapping: true,
            value: "请输入sql",
            extraKeys: {
                'Ctrl': 'autocomplete',
                "Ctrl-Space": editor => {
                    editor.showHint();
                }
            }
        });
        this.editor.on("keypress", editor => {
            editor.showHint();
        });
    }
};
</script>

<style scoped>
</style>
