# UD2 — Normalization (1NF / 2NF) · Normalización (1FN / 2FN)

**Source / Fuente:** *Bases de datos — Caso 1 unidad 2* (.docx in this folder). :contentReference[oaicite:5]{index=5}

## EN
**Case 1 — 1NF.** Original table had repeating groups in `ASIGNATURA`. Split into **Alumno**, **Asignatura**, and **Matricula** (N:M). :contentReference[oaicite:6]{index=6}  
**Case 2 — 2NF.** Partial dependency: `NOMBRE ART.` depends on `COD. ART.` only. Split **Factura** and **Articulo** (1:N). :contentReference[oaicite:7]{index=7}

**Benefit.** Less redundancy, better integrity, cleaner queries. :contentReference[oaicite:8]{index=8}

## ES
**Caso 1 — 1FN.** La tabla original tenía grupos repetitivos en `ASIGNATURA`. Se separa en **Alumno**, **Asignatura** y **Matricula** (N:M). :contentReference[oaicite:9]{index=9}  
**Caso 2 — 2FN.** Dependencia parcial: `NOMBRE ART.` depende solo de `COD. ART.`. Se separa **Factura** y **Articulo** (1:N). :contentReference[oaicite:10]{index=10}

**Ventaja.** Menos redundancia, mejor integridad y consultas más claras. :contentReference[oaicite:11]{index=11}

---

✍️ **Author / Autora:** Ana Vertedor · *Alias:* Nerine Aoi
