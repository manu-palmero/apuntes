import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"
import { capitalize, classNames } from "../util/lang"

type Options = {
  capitalizeFirstLetter?: boolean
}

const defaultOptions: Options = {
  capitalizeFirstLetter: false,
}

export default ((userOpts?: Partial<Options>) => {
  const opts: Options = { ...defaultOptions, ...userOpts }

  const ArticleTitle: QuartzComponent = ({ fileData, displayClass }: QuartzComponentProps) => {
    const title = fileData.frontmatter?.title
    if (title) {
      const renderedTitle = opts.capitalizeFirstLetter ? capitalize(title) : title
      return <h1 class={classNames(displayClass, "article-title")}>{renderedTitle}</h1>
    } else {
      return null
    }
  }

  ArticleTitle.css = `
.article-title {
  margin: 2rem 0 0 0;
}
`

  return ArticleTitle
}) satisfies QuartzComponentConstructor
