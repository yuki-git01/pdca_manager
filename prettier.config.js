module.exports = {
  plugins: [
    async () => {
      const prettierPluginJava = await import('prettier-plugin-java');
      return prettierPluginJava.default || prettierPluginJava;
    }
  ],
  printWidth: 140,
  useTabs: false,
  semi: true,
  singleQuote: false,
  overrides: [
    {
      files: '*.java',
      options: {
        parser: 'java'
      }
    }
  ]
};