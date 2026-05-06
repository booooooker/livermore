# AGENTS.md

## Cursor Cloud specific instructions

This is a **content-only repository** — an AI persona/Skill definition based on Jesse Livermore's trading philosophy. It contains only Markdown (`.md`) and plain text (`.txt`) files. There are no code dependencies, build systems, package managers, or services to run.

### Repository structure

- `livermore-skill/SKILL.md` — Core Skill definition (persona prompt with identity, mental models, decision heuristics, expression DNA)
- `livermore-skill/references/research/` — Research materials (7+ files covering writings, conversations, decisions, personal life, cases, timeline, quotes)
- `livermore-skill/references/sources/books/` — Source book text (Chinese)
- `livermore-skill/references/extraction-framework.md`, `quality-test.md`, `refinement-report.md` — Skill refinement methodology

### Linting

Run markdown lint with `pymarkdown`:

```sh
pymarkdown scan README.md livermore-skill/README.md livermore-skill/SKILL.md \
  livermore-skill/references/*.md livermore-skill/references/research/*.md
```

Pre-existing lint warnings (mostly MD022 blank-lines-around-headings and MD047 trailing newlines) are known. The linter returns a non-zero exit code when warnings are found — this is expected for the current content.

### No build / test / run steps

There are no automated tests, no build steps, and no services to start. The "product" is the `SKILL.md` file, which is loaded into an AI platform that supports persona Skills.
