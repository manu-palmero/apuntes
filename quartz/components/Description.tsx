import { QuartzComponent, QuartzComponentConstructor, QuartzComponentProps } from "./types"

const Description: QuartzComponent = ({ fileData, displayClass }: QuartzComponentProps) => {
  const description = fileData.frontmatter?.tags?.find((tag) => /^description[/:=].+/i.test(tag))?.replace(/^description[/:=]\s*/i, "")?.trim() || fileData.description?.trim() || ""
  
  if (description) {
    return (
      <p class={`${displayClass ?? ""} page-description`}>
        {description}
      </p>
    )
  }
  
  return null
}

Description.css = `
.page-description {
  margin: 1rem 0;
  opacity: 0.8;
  font-size: 0.95em;
  line-height: 1.5;
  color: var(--darkgray);
}

.dark .page-description {
  color: var(--lightgray);
}
`

export default (() => Description) satisfies QuartzComponentConstructor
